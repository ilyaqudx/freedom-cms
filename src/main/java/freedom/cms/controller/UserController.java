package freedom.cms.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import freedom.cms.Kit;
import freedom.cms.Result;
import freedom.cms.SessionUtils;
import freedom.cms.annotation.PublicAPI;
import freedom.cms.domain.Bank;
import freedom.cms.domain.User;
import freedom.cms.mapper.BankMapper;
import freedom.cms.mapper.RegionMaaper;
import freedom.cms.mapper.ResourceMapper;
import freedom.cms.mapper.UserMapper;

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
		return list(mv, page);
	}
	
	@PublicAPI
	@RequestMapping(value = "/user/login")
	public ModelAndView login(HttpServletRequest request,Long userId,String password,String kaptcha){
		User user = userMapper.get(userId);
		if(user == null)
			throw new IllegalArgumentException("用户名不存在");
		if(!user.getLoginPassword().equals(password))
			throw new IllegalArgumentException("密码错误");
		
		String sessionKaptcha = SessionUtils.getKaptcha(request);
		if(!sessionKaptcha.equalsIgnoreCase(kaptcha)){
			throw new IllegalArgumentException("验证码不正确");
		}
		//登陆成功
		List<String> resources = resourceMapper.listUserResource(userId);
		SessionUtils.putUserInSession(request, user);
		SessionUtils.putUserResourceInSession(request, resources);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/user/list")
	public ModelAndView list(ModelAndView mv,Page<User> page){
		PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 10));
		List<User> users = userMapper.list();
		mv.addObject("users", users);
		mv.setViewName("/view/vip-list.jsp");
		return mv;
	}
	
	@RequestMapping("/user/tableList")
	public Object listByDataTable(DataTable<User> table)
	{
		PageHelper.startPage(Math.max(table.getPageNum(), 1), Math.max(table.getPageSize(), 10),true);
		List<User> users = userMapper.list();
		table.setData(users);
		table.setRecordsTotal(table.getPages());
		Map<String,Object> map = new HashMap<>();
		map.put("data",users);
		map.put("recordsTotal", table.getTotal());
		return map;
	}
}
