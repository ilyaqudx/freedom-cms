package freedom.cms.controller;

import java.io.IOException;
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
import freedom.cms.domain.Bank;
import freedom.cms.domain.User;
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
	
	
	@RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return userMapper.get(id);
	}
	
	@PublicAPI
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public ModelAndView get(ModelAndView mv){
		mv.setViewName("/view/login.jsp");
		mv.addObject("code", new Random().nextInt(10) + ".PNG");
		return mv;
	}
	@PublicAPI
	@RequestMapping(value = "/refreshCode" , method = RequestMethod.POST)
	public Result<?> refreshCode(HttpServletRequest request,ModelAndView mv){
		int index = new Random().nextInt(10);
		String code =  index+ ".PNG";
		SessionUtils.putKaptcha(request, SessionUtils.VERIFY_CODES.get(index));
		return Result.ok(code);
	}
	
	/**
	 * 返回数据:
	 * 银行列表
	 * 省份-市-区
	 * 自动生成的会员编号(一开始就生成好)
	 * 
	 * */
	@RequestMapping(value = "/user/add",method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv,User user)
	{
		List<String> provinces = regionMapper.listProvince();
		List<Bank> banks = bankMapper.list();
		String code = "a" + Kit.generatorNumber(6);
		boolean isExist = userMapper.isExist(code) > 0;
		user.setCode(code);
		mv.addObject("provinces", provinces);
		mv.addObject("banks",banks);
		mv.addObject("user",user);
		mv.setViewName("/view/vip-add.jsp");
		return mv;
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
	public ModelAndView post(ModelAndView mv,Page<User> page,HttpServletRequest request,User user){
		user.setStatus(0);
		user.setCreateTime(new Date());
		System.out.println(user);
		userMapper.insert(user);
		return list(mv, page,new UserQuery());
	}
	
	
	@RequestMapping(value = "/user/update",method=RequestMethod.POST)
	public ModelAndView update(ModelAndView mv,HttpServletRequest request,User user){
		userMapper.update(user);
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
	
	@RequestMapping(value = "/user/changePassword",method=RequestMethod.POST)
	public ModelAndView changePassword(ModelAndView mv,HttpServletRequest request,ChangePasswordVO vo){
		
		User user = SessionUtils.getUserInSession(request);
		if(Kit.isNotBlank(vo.getOldLoginPassword()) && Kit.isNotBlank(vo.getNewLoginPassword())){
			if(user.getLoginPassword().equals(vo.getOldLoginPassword())){
				user.setLoginPassword(vo.getNewLoginPassword());
				userMapper.update(user);
				mv.addObject("error", "一级密码修改成功");
			}else{
				mv.addObject("error", "旧一级密码不正确");
			}
		}
		if(Kit.isNotBlank(vo.getOldPayPassword()) && Kit.isNotBlank(vo.getNewPayPassword())){
			if(user.getPayPassword().equals(vo.getOldPayPassword())){
				user.setPayPassword(vo.getNewPayPassword());
				userMapper.update(user);
				mv.addObject("error", "二级密码修改成功");
			}else{
				mv.addObject("error", "旧二级密码不正确");
			}
		}
		return security(mv, request);
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
	public ModelAndView list(ModelAndView mv,Page<User> page,UserQuery query){
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
	public void home(HttpServletRequest request,HttpServletResponse response)
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
