package freedom.cms.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import freedom.cms.Kit;
import freedom.cms.P;
import freedom.cms.SessionUtils;
import freedom.cms.domain.Achievement;
import freedom.cms.domain.User;
import freedom.cms.mapper.AchievementMapper;
import freedom.cms.query.AchievementQuery;

@RestController
@RequestMapping("/achievement")
public class AchievementController {

	@Autowired
	private AchievementMapper achievementMapper;
	
	@RequestMapping(value = "/add",method =RequestMethod.GET)
	public ModelAndView add(ModelAndView mv){
		mv.setViewName("/view/achievement-add.jsp");
		return mv;
	}
	
	@RequestMapping(value = "/edit",method =RequestMethod.GET)
	public ModelAndView edit(ModelAndView mv,Long id){
		Achievement a = achievementMapper.get(id);
		mv.addObject("a",a);
		return add(mv);
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
	
	@RequestMapping(value = "/add",method =RequestMethod.POST)
	public ModelAndView post(ModelAndView mv,Achievement achievement){
		try {
			String level = achievement.getLevel();
			String openShopStatus = achievement.getOpenShopStatus();
			achievement.setLevel(encoding(level));
			achievement.setOpenShopStatus(encoding(openShopStatus));
			if(Kit.isBlank(achievement.getId())){
				
				achievementMapper.insert(achievement);
				mv.addObject("error", "添加成功");
			}else{
				achievementMapper.update(achievement);
				mv.addObject("error", "更新成功");
			}
		} catch (Exception e) {
			mv.addObject("操作失败");
		}
		return add(mv);
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv,Page<Achievement> page,AchievementQuery query,HttpServletRequest request){
		page = PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 10),true);
		List<Achievement> as = achievementMapper.list(query);
		P p = new P();
		p.setCurrentPage(page.getPageNum());
		p.setTotalPage(page.getPages());
		p.setTotalCount(page.getTotal());
		p.setFirstPage(1);
		p.setLastPage(p.getTotalPage());
		mv.addObject("as", as);
		mv.addObject("p", p);
		mv.addObject("q", query);
		mv.setViewName("/view/achievement-list.jsp");
		return mv;
	}
}
