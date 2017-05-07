package com.iquizoo.manage.web.admin.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.controller.BaseController;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.web.admin.po.Admin;
import com.iquizoo.manage.web.admin.po.Role;
import com.iquizoo.manage.web.admin.service.AdminService;
import com.iquizoo.manage.web.admin.service.RoleService;
import com.iquizoo.manage.web.bank.dao.BankAccountDAO;
import com.iquizoo.manage.web.bank.dao.BankDAO;
import com.iquizoo.manage.web.bank.po.Bank;
import com.iquizoo.manage.web.bank.po.BankAccount;
import com.iquizoo.manage.web.bank.vo.AdminVO;
import com.iquizoo.manage.web.system.service.SystemLogService;

/**
 * @Description 管理员
 * @author GouZhongLiang
 * @date 2016-6-14 上午9:28:51
 */
@RequestMapping("admin")
@Controller
public class AdminController extends BaseController{

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private SystemLogService systemLogService;
	
	@Autowired
	private BankDAO bankDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@RequestMapping(method=RequestMethod.GET, value="/list")
	public ModelAndView list() throws Exception{
//		Page page = new Page(currentPage, pageSize);
//		page = adminService.list(page);
//		Map<String,Object> map = new HashMap<String,Object>();
//		map.put("page", page);
		return new ModelAndView("admin/admin-list");
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/list")
	@ResponseBody
	public String listData(DataTable table) throws Exception{
		adminService.data(table);
		return JSON.toJSONString(table);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/add")
	public ModelAndView add(Integer id) throws Exception{
		ModelAndView model = new ModelAndView("admin/admin-add");
		if(id != null){
			Admin admin = adminService.getAdminById(id);
			model.addObject("admin", admin);
		}
		List<Role> roles = roleService.getAllRole();
		List<Bank> banks = bankDAO.getBankList();
		model.addObject("roles", roles);
		model.addObject("banks", banks);
		System.out.println(Arrays.toString(banks.toArray()));
		return model;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/edit")
	public ModelAndView edit(Integer id) throws Exception{
		ModelAndView model = new ModelAndView("admin/admin-edit");
		if(id != null){
			Admin admin = adminService.getAdminById(id);
			BankAccount account = bankAccountDAO.getAccountBankByUserId(admin.getId());
			AdminVO adminVO = new AdminVO();
			BeanUtils.copyProperties(admin, adminVO);
			if(null != account){
				BeanUtils.copyProperties(account, adminVO);
			}
			adminVO.setId(admin.getId());
			model.addObject("admin", adminVO);
		}
		List<Role> roles = roleService.getAllRole();
		model.addObject("roles", roles);
		return model;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/add")
	@ResponseBody
	public String addAdmin(String params) throws Exception{
		AdminVO adminVO = JSON.parseObject(params, AdminVO.class);
		adminService.addAdmin(adminVO);
		//插入银行信息
		BankAccount account = new BankAccount();
		account.setUserId(adminVO.getId());
		BeanUtils.copyProperties(adminVO, account);
		account.setId(null);
		bankAccountDAO.addBankAccount(account);
		return success();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/edit")
	@ResponseBody
	public String editAdmin(String params) throws Exception{
		Admin admin = JSON.parseObject(params, Admin.class);
		System.out.println(admin);
		adminService.updateAdmin(admin);
		return success();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/delete")
	@ResponseBody
	public String deleteAdmin(Integer id) throws Exception{
		adminService.deleteAdmin(id);
		return success();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/stop")
	@ResponseBody
	public String stop(Integer id) throws Exception{
		adminService.stop(id);
		return success();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/start")
	@ResponseBody
	public String start(Integer id) throws Exception{
		adminService.start(id);
		return success();
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout() throws Exception{
		systemLogService.addLogoutLog();
		AppContext.getSession().invalidate();
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editPass")
	public ModelAndView editPass(Integer id) throws Exception{
		return new ModelAndView("admin/admin-editPass").addObject("id", id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/editPass")
	@ResponseBody
	public String editPass(Admin admin) throws Exception{
		adminService.updateAdminPass(admin);
		return success();
	}
}
