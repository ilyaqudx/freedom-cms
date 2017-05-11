package freedom.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import freedom.cms.Kit;
import freedom.cms.P;
import freedom.cms.domain.CashOrder;
import freedom.cms.domain.User;
import freedom.cms.mapper.CashOrderMapper;
import freedom.cms.mapper.UserMapper;
import freedom.cms.query.CashOrderQuery;
import freedom.cms.vo.UserVO;

@RestController
@RequestMapping("/order")
public class CashOrderController {

	
	@Autowired
	private CashOrderMapper cashOrderMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 返回数据:
	 * 
	 * 用户信息
	 * 目前拥有的奖金币数量
	 * */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public ModelAndView add(ModelAndView mv,User user)
	{
		user = userMapper.get(user.getId());
		mv.addObject("user",user);
		mv.setViewName("/view/order-add.jsp");
		return mv;
	}
	
	/**
	 * 返回数据:
	 * 
	 * 用户信息
	 * 目前拥有的奖金币数量
	 * */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public CashOrder add(CashOrder order)
	{
		System.out.println(order);
		order.setActualAmount(order.getAmount());
		order.setCreateTime(new Date());
		order.setStatus(CashOrder.STATUS_PROCESSING);
		order.setOrderNo(Kit.time2String(new Date(), "yyMMddHHmmss"+order.getUserId()+Kit.generatorNumber(4)));
		cashOrderMapper.insert(order);
		return order;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv,Page<CashOrder> page,CashOrderQuery query){
		page = PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 2),true);
		List<CashOrder> orders = cashOrderMapper.list(query);
		P p = new P();
		p.setCurrentPage(page.getPageNum());
		p.setTotalPage(page.getPages());
		p.setTotalCount(page.getTotal());
		p.setFirstPage(1);
		p.setLastPage(p.getTotalPage());
		mv.addObject("orders", orders);
		mv.addObject("p", p);
		mv.addObject("q", query);
		mv.setViewName("/view/order-list.jsp");
		return mv;
	}
}
