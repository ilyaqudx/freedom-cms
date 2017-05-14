package freedom.cms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
import freedom.cms.domain.CashOrder;
import freedom.cms.domain.User;
import freedom.cms.mapper.AchievementMapper;
import freedom.cms.mapper.CashOrderMapper;
import freedom.cms.mapper.UserMapper;
import freedom.cms.query.CashOrderQuery;
import freedom.cms.vo.CashOrderVO;

@RestController
@RequestMapping("/order")
public class CashOrderController {

	
	@Autowired
	private CashOrderMapper cashOrderMapper;
	@Autowired
	private AchievementMapper achievementMapper;
	/**
	 * 返回数据:
	 * 
	 * 用户信息
	 * 目前拥有的奖金币数量
	 * */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public ModelAndView add(HttpServletRequest request,ModelAndView mv)
	{
		User user = SessionUtils.getUserInSession(request);
		mv.addObject("user",user);
		Achievement a = achievementMapper.getByCode(user.getCode());
		mv.addObject("a", a);
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
	public ModelAndView add(HttpServletRequest request,ModelAndView mv,CashOrder order,String payPassword)
	{
		//验证二级密码是否正确
		System.out.println("paypassword : " + payPassword);
		User user = SessionUtils.getUserInSession(request);
		if(!user.getPayPassword().equals(payPassword)){
			mv.addObject("error","二级密码错误");
		}else{
			//验证金额是否充足
			try {
				Achievement a = achievementMapper.getByCode(user.getCode());
				if(order.getAmount() <= 0 || a.getBonusCoin() < order.getAmount()){
					mv.addObject("error","奖金币不足");
				}
				else{
					System.out.println(order);
					float amount = order.getAmount() == null ? 0 : order.getAmount();
					int validAmount = (int) amount;
					if(validAmount % 100 != 0)
						throw new IllegalArgumentException();
					order.setAmount(order.getAmount());
					order.setActualAmount(order.getAmount());
					order.setCreateTime(new Date());
					order.setStatus(CashOrder.STATUS_PROCESSING);
					order.setOrderNo(Kit.time2String(new Date(), "yyMMddHHmmss"+order.getUserId()+Kit.generatorNumber(4)));
					cashOrderMapper.insert(order);
					mv.addObject("error","申请提交成功");
				}
				
			} catch (NumberFormatException e) {
				e.printStackTrace();
				mv.addObject("error","提现金额必须是100的整数倍，请重新输入！");
			}
		}
		return add(request, mv);
	}
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mv,Page<CashOrder> page,CashOrderQuery query,HttpServletRequest request){
		page = PageHelper.startPage(Math.max(page.getPageNum(), 1), Math.max(page.getPageSize(), 2),true);
		User user = SessionUtils.getUserInSession(request);
		if(user.getAdmin() != Kit.TRUE){
			//如果不是管理员只能查看自己的
			query.setUserId(user.getId());
		}
		
		List<CashOrderVO> vos = new ArrayList<CashOrderVO>();
		List<CashOrder> orders = cashOrderMapper.list(query);
		
		if(Kit.isNotBlank(orders)){
			if(user.getAdmin() != Kit.TRUE){
				for (CashOrder o : orders) {
					CashOrderVO vo = Kit.copy(o, CashOrderVO.class);
					vo.setName(user.getName());
					vo.setCode(user.getCode());
					vos.add(vo);
				}
			}else{
				//如果是管理员,那订单用户需要一个一个查询
				for (CashOrder o : orders) {
					User ouser = userMapper.get(o.getUserId());
					if(user != null){
						CashOrderVO vo = Kit.copy(o, CashOrderVO.class);
						vo.setName(ouser.getName());
						vo.setCode(ouser.getCode());
						vos.add(vo);
					}
				}
			}
		}
		
		P p = new P();
		p.setCurrentPage(page.getPageNum());
		p.setTotalPage(page.getPages());
		p.setTotalCount(page.getTotal());
		p.setFirstPage(1);
		p.setLastPage(p.getTotalPage());
		mv.addObject("orders", vos);
		mv.addObject("p", p);
		mv.addObject("q", query);
		mv.setViewName("/view/order-list.jsp");
		return mv;
	}
}
