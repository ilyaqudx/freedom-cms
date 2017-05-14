package freedom.cms.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import freedom.cms.Kit;
import freedom.cms.P;
import freedom.cms.Result;
import freedom.cms.SessionUtils;
import freedom.cms.annotation.NotPayPassword;
import freedom.cms.annotation.PublicAPI;
import freedom.cms.domain.Achievement;
import freedom.cms.domain.Bank;
import freedom.cms.domain.Region;
import freedom.cms.domain.User;
import freedom.cms.mapper.AchievementMapper;
import freedom.cms.mapper.BankMapper;
import freedom.cms.mapper.RegionMaaper;
import freedom.cms.mapper.ResourceMapper;
import freedom.cms.mapper.UserMapper;
import freedom.cms.query.UserQuery;
import freedom.cms.vo.ChangePasswordVO;
import freedom.cms.vo.LoginVO;
import freedom.cms.vo.UserVO;

/**  
 * 创建时间: 2017年5月3日 下午12:22:51  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: UserController.java  
 * 类说明:  
 */
@RestController
public class UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	@Autowired
	private BankMapper bankMapper;
	@Autowired
	private RegionMaaper regionMapper;
	@Autowired
	private AchievementMapper achievementMapper;
	
	
	@RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return userMapper.get(id);
	}
	
	@PublicAPI
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request,ModelAndView mv){
		mv.setViewName("/view/login.jsp");
		return mv;
	}
	@PublicAPI
	@RequestMapping(value = "/refreshCode" , method = RequestMethod.POST)
	public Result<?> refreshCode(HttpServletRequest request,ModelAndView mv){
		String code = randomVerifyCode(request);
		return Result.ok(code);
	}

	private String randomVerifyCode(HttpServletRequest request) {
		int index = new Random().nextInt(10);
		String code =  index+ ".PNG";
		SessionUtils.putKaptcha(request, SessionUtils.VERIFY_CODES.get(index));
		System.out.println("生成登陆验证码 : " + code + "," +SessionUtils.getKaptcha(request));
		return code;
	}
	
	/**
	 * 返回数据:
	 * 银行列表
	 * 省份-市-区
	 * 自动生成的会员编号(一开始就生成好)
	 * 
	 * */
	@RequestMapping(value = "/user/add",method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request,ModelAndView mv,User u)
	{
		if(Kit.isNotBlank(u.getCode())){
			//将省市区全部返回
			if(Kit.isNotBlank(u.getProvince())){
				Region p = regionMapper.get(u.getProvince());
				if(p != null){
					List<String> citys = regionMapper.listCity(p.getCode());
					mv.addObject("citys", citys);
					Region c = regionMapper.get(u.getCity());
					if(c != null){
						List<String> areas = regionMapper.listCity(c.getCode());
						mv.addObject("areas",areas);
					}
				}
			}
		}else{
			String code = "w" + Kit.generatorNumber(6);
			u.setCode(code);
		}
		List<String> provinces = regionMapper.listProvince();
		List<Bank> banks = bankMapper.list();
		mv.addObject("provinces", provinces);
		mv.addObject("banks",banks);
		mv.addObject("u",u);
		mv.addObject("user",SessionUtils.getUserInSession(request));
		mv.setViewName("/view/vip-add.jsp");
		return mv;
	}
	
	private String encoding(String str)
	{
		if(Kit.isNotBlank(str)){
			try {
				return new String(str.getBytes("ISO-8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return str;
	}
	
	/**
	 * 返回数据:
	 * 银行列表
	 * 省份-市-区
	 * 自动生成的会员编号(一开始就生成好)
	 * 
	 * */
	@RequestMapping(value = "/user/edit",method = RequestMethod.GET)
	public ModelAndView edit(ModelAndView mv,HttpServletRequest request)
	{
		User user = SessionUtils.getUserInSession(request);
		List<Bank> banks = bankMapper.list();
		user = userMapper.get(user.getId());
		//身份证后6位隐藏
		if(Kit.isNotBlank(user.getIdentityCode())){
			try {
				String id = user.getIdentityCode();
				if(id.length() >= 6){
					String str = id.substring(id.length() - 6);
					user.setIdentityCode(id.replace(str, "******"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		mv.addObject("banks",banks);
		mv.addObject("user",user);
		mv.setViewName("/view/vip-edit.jsp");
		return mv;
	}
	
	@RequestMapping("/user/refreshCode")
	public Result<?> refreshCode()
	{
		boolean exist = true;
		String code = null;
		do {
			code = "a" + Kit.generatorNumber(6);
			exist = userMapper.isExist(code) > 0;
		} while (exist);
		return Result.ok(code);
	}
	@RequestMapping("/user/checkCode")
	public <V> Result<V> checkCode(String code,Integer type)
	{
		Long exist = userMapper.isExist(code);
		if(type != 3){
			if(exist != null && exist > 0)
				return Result.ok();
		}else{
			if(exist == null || exist <= 0)
				return Result.ok();
		}
		return Result.err("编码无效或不存在");
	}
	
	/**
	 * 你妹的,JACKSON超级难用.@RequestBody绑定前端的JSON字符串到对象字段必须要一一对应,不能多也不能少,否则直接来415.我靠
	 * 
	 * data : JSON.stringify(data)
	 * contentType : "application/json"
	 * */
	@RequestMapping(value = "/user/add",method=RequestMethod.POST)
	public ModelAndView post(ModelAndView mv,Page<User> page,HttpServletRequest request,User u){
		System.out.println(u);
		String name = u.getName();
		String accountName = u.getBankAccountName();
		String bankAddress = u.getBankAddress();
		String receivAddress = u.getReceivingAddress();
		String bank = u.getBank();
		String province = u.getProvince();
		String city = u.getCity();
		String area = u.getArea();
		
		u.setName(encoding(name));
		u.setBankAccountName(encoding(accountName));
		u.setBankAddress(encoding(bankAddress));
		u.setReceivingAddress(encoding(receivAddress));
		u.setBank(encoding(bank));
		u.setProvince(encoding(province));
		u.setCity(encoding(city));
		u.setArea(encoding(area));
		
		//验证推荐人编号
		User remommender = userMapper.getByCode(u.getRecommender());
		if(null == remommender){
			mv.addObject("error","推荐人编号无效");
			return add(request,mv,u);
		}
		
		User settler = userMapper.getByCode(u.getSettler());
		if(null == settler){
			mv.addObject("error","安置人编码无效");
			return add(request,mv,u);
		}
		
		User coder = userMapper.getByCode(u.getCode());
		if(null != coder){
			mv.addObject("error","会员编号无效");
			return add(request,mv,u);
		}
		
		//添加成功
		u.setStatus(0);
		u.setCreateTime(new Date());
		u.setActivationTime(new Date());
		u.setAdmin(0);
		System.out.println(u);
		userMapper.insert(u);
		mv.addObject("error","添加成功");
		
		//同时添加用户的业绩
		Achievement a = new Achievement();
		a.setCode(u.getCode());
		a.setBaoDanCoin(0D);
		a.setBaoDanGouWuCoin(0D);
		a.setBonusCoin(0D);
		a.setElectronicCoin(0D);
		a.setRepeatSaleCoin(0D);
		a.setElectCoinCumulative(0D);
		a.setLevel("会员");
		achievementMapper.insert(a);
		return add(request,mv, new User());
	}
	
	
	@RequestMapping(value = "/user/update",method=RequestMethod.POST)
	public ModelAndView update(ModelAndView mv,HttpServletRequest request,User user){
		System.out.println(user);
		String name = user.getName();
		String accountName = user.getBankAccountName();
		String bankAddress = user.getBankAddress();
		String receivAddress = user.getReceivingAddress();
		String bank = user.getBank();
		String province = user.getProvince();
		String city = user.getCity();
		String area = user.getArea();
		
		user.setName(encoding(name));
		user.setBankAccountName(encoding(accountName));
		user.setBankAddress(encoding(bankAddress));
		user.setReceivingAddress(encoding(receivAddress));
		user.setBank(encoding(bank));
		user.setProvince(encoding(province));
		user.setCity(encoding(city));
		user.setArea(encoding(area));
		System.out.println(user);
		userMapper.update(user);
		//更新缓存
		user = userMapper.get(user.getId());
		SessionUtils.putUserInSession(request, user);
		return edit(mv,request);
	}
	
	@NotPayPassword
	@RequestMapping("/user/security")
	public ModelAndView security(ModelAndView mv,HttpServletRequest request)
	{
		User user = SessionUtils.getUserInSession(request);
		mv.addObject("id", user.getId());
		mv.setViewName("/view/vip-security.jsp");
		return mv;
	}
	
	@NotPayPassword
	@RequestMapping(value = "/user/changePassword",method=RequestMethod.POST)
	public Result<?> changePassword(ModelAndView mv,HttpServletRequest request,ChangePasswordVO vo){
		
		User user = SessionUtils.getUserInSession(request);
		if(vo.getChangeType() == ChangePasswordVO.TYPE_LOGIN_PWD)
		{
			if(user.getLoginPassword().equals(vo.getOldLoginPassword())){
				user.setLoginPassword(vo.getNewLoginPassword());
				userMapper.update(user);
				return Result.ok("一级密码修改成功");
			}else{
				return Result.err("原一级密码不正确");
			}
		}
		else if(vo.getChangeType() == ChangePasswordVO.TYPE_PAY_PWD){
			if(user.getPayPassword().equals(vo.getOldPayPassword())){
				user.setPayPassword(vo.getNewPayPassword());
				userMapper.update(user);
				return Result.ok("二级密码修改成功");
			}else{
				return Result.err("原二级密码不正确");
			}
		}
		return Result.err("修改密码失败");
	}
	
	/**输入支付密码页面
	 * @param request
	 * @param payPassword
	 * @return
	 */
	@NotPayPassword
	@RequestMapping(value = "/inputPayPwd",method=RequestMethod.GET)
	public ModelAndView inputPayPwd(){
		return new ModelAndView("/view/input-paypwd.jsp");
	}
	
	/**验证支付密码
	 * @param request
	 * @param payPassword
	 * @return
	 */
	@NotPayPassword
	@RequestMapping(value = "/verifyPayPwd",method=RequestMethod.POST)
	public Result<?> verifyPayPwd(HttpServletRequest request,String payPassword){
		User user = SessionUtils.getUserInSession(request);
		if(!user.getPayPassword().equals(payPassword)){
			return Result.err("二级密码错误");
		}
		//登陆成功
		SessionUtils.putPayPasswordInSession(request, user.getPayPassword());
		String view = (String) SessionUtils.getAndDelAttr(request, SessionUtils.PAY_PASSWORD_VIEW);
		//页面直接去跳转即可
		return Result.ok(view);
	}
	
	@PublicAPI
	@RequestMapping(value = "/user/login")
	public Result<?> login(HttpServletRequest request,HttpServletResponse resp,
			@RequestBody LoginVO vo){
		User user = userMapper.getByCode(vo.getCode());
		if(user == null){
			return Result.err("用户不存在");
		}
		if(!user.getLoginPassword().equals(vo.getLoginPassword())){
			return Result.err("密码错误");
		}
		
		String sessionKaptcha = SessionUtils.getKaptcha(request);
		if(null == sessionKaptcha || !sessionKaptcha.equalsIgnoreCase(vo.getKaptcha())){
			return Result.err("验证码错误");
		}
		//登陆成功
		List<String> resources = resourceMapper.listUserResource(user.getId());
		SessionUtils.putUserInSession(request, user);
		SessionUtils.putUserResourceInSession(request, resources);
		return Result.ok();
	}
	
	@RequestMapping("/user/list")
	public ModelAndView list(ModelAndView mv,Page<User> page,UserQuery query,HttpServletRequest request){
		page = PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 2),true);
		query.setName(encoding(query.getName()));
		User user = SessionUtils.getUserInSession(request);
		if(user.getAdmin() != Kit.TRUE){
			//如果不是管理员,只能查看自己发展的会员信息
			query.setRecommender(user.getCode());
		}else{
			query.setAdminCode(user.getCode());
		}
		
		List<User> users = userMapper.list(query);
		List<UserVO> vos = new ArrayList<UserVO>();
		users.stream().forEach(u ->{
			try {
				UserVO vo = Kit.copy(u, UserVO.class);
				String recommenderName = userMapper.getByCode(vo.getRecommender()).getName();
				String settlerName = userMapper.getByCode(vo.getSettler()).getName();
				vo.setRecommenderName(recommenderName);
				vo.setSettlerName(settlerName);
				vos.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		P p = new P();
		p.setCurrentPage(page.getPageNum());
		p.setTotalPage(page.getPages());
		p.setTotalCount(page.getTotal());
		p.setFirstPage(1);
		p.setLastPage(p.getTotalPage());
		mv.addObject("users", vos);
		mv.addObject("p", p);
		mv.addObject("q", query);
		mv.setViewName("/view/vip-list.jsp");
		return mv;
	}
	
	@RequestMapping("/user/activation")
	public ModelAndView activation(ModelAndView mv,Page<User> page,UserQuery query){
		page = PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 2),true);
		List<User> users = userMapper.list(query);
		List<UserVO> vos = new ArrayList<UserVO>();
		users.stream().forEach(u ->{
			try {
				UserVO vo = Kit.copy(u, UserVO.class);
				String recommenderName = userMapper.getByCode(vo.getRecommender()).getName();
				String settlerName = userMapper.getByCode(vo.getSettler()).getName();
				vo.setRecommenderName(recommenderName);
				vo.setSettlerName(settlerName);
				vos.add(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		P p = new P();
		p.setCurrentPage(page.getPageNum());
		p.setTotalPage(page.getPages());
		p.setTotalCount(page.getTotal());
		p.setFirstPage(1);
		p.setLastPage(p.getTotalPage());
		mv.addObject("users", vos);
		mv.addObject("p", p);
		mv.addObject("q", query);
		mv.setViewName("/view/vip-list.jsp");
		return mv;
	}
	
	@NotPayPassword
	@RequestMapping("/user/logout")
	public void logout(HttpServletRequest request,HttpServletResponse response)
	{
		SessionUtils.delAttr(request, SessionUtils.USER_IN_SESSION);
		SessionUtils.delAttr(request, SessionUtils.PAY_PASSWORD_VIEW);
		SessionUtils.delAttr(request, SessionUtils.USER_PAY_PASSWORD);
		try {
			response.sendRedirect("/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
