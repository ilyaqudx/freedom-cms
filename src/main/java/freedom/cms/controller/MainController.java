package freedom.cms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import freedom.cms.SessionUtils;
import freedom.cms.annotation.NotPayPassword;
import freedom.cms.domain.Menu;
import freedom.cms.mapper.MenuMapper;
import freedom.cms.vo.MenuVO;

/**  
 * 创建时间: 2017年5月4日 上午12:21:12  
 * 项目名称: freedom-cms  
 * @author freedom  
 * @version 1.0   
 * @since JDK 1.8.0_21  
 * 文件名称: MainController.java  
 * 类说明:  
 */
@Controller
public class MainController {

	@Autowired
	private MenuMapper menuMapper;
	
	@NotPayPassword
	@RequestMapping("/")
	public ModelAndView home(HttpServletRequest request,ModelAndView mv)
	{
		List<Menu> menus = menuMapper.listParentMenu();
		List<Menu> children = menuMapper.listChildren(menus.get(0).getId());
		List<MenuVO> vos = new ArrayList<MenuVO>();
		MenuVO vo = new MenuVO();
		vo.setMenu(menus.get(0));
		vo.setChildren(children);
		vos.add(vo);
		mv.setViewName("view/index.jsp");
		mv.addObject("menus", vos);
		mv.addObject("user",SessionUtils.getUserInSession(request));
		return mv;
	}
}
