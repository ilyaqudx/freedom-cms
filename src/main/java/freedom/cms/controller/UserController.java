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

import freedom.cms.domain.Resource;
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
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ResourceMapper resourceMapper;
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public User get(@PathVariable Long id){
		return userMapper.get(id);
	}
	
	@RequestMapping(value = "/insert")
	public Long post(String name,String identityCode){
		User user = new User();
		user.setName(name);
		user.setIdentityCode(identityCode);
		user.setCreateTime(new Date());
		return userMapper.insert(user);
	}
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,Long userId){
		User user = userMapper.get(userId);
		List<String> resources = resourceMapper.listUserResource(userId);
		request.getSession().setAttribute("user_in_session", user);
		request.getSession().setAttribute("user_resources", resources);
		return new ModelAndView("redirect:/");
	}
}
