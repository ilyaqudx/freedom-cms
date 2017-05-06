package freedom.cms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import freedom.cms.SessionUtils;
import freedom.cms.annotation.PublicAPI;
import freedom.cms.domain.User;
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
	
	@RequestMapping(value = "/user/{id}" , method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return userMapper.get(id);
	}
	
	@RequestMapping(value = "/user/add",method=RequestMethod.POST)
	public Long post( User user){
		user.setCreateTime(new Date());
		return userMapper.insert(user);
	}
	
	@PublicAPI
	@RequestMapping(value = "/user/login")
	public ModelAndView login(HttpServletRequest request,Long userId,String password,String kaptcha){
		User user = userMapper.get(userId);
		if(user == null)
			throw new IllegalArgumentException("用户名不存在");
		if(!user.getPassword().equals(password))
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
	public ModelAndView list(ModelAndView mv){
		List<User> users = userMapper.list();
		mv.addObject("users", users);
		mv.setViewName("/member-list.jsp");
		return mv;
	}
}
