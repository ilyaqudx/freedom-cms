package com.iquizoo.manage.web.vip.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.AccountService;
import com.iquizoo.manage.web.user.service.UserService;
import com.iquizoo.manage.web.vip.dto.AccountVipDTO;
import com.iquizoo.manage.web.vip.po.AccountVip;
import com.iquizoo.manage.web.vip.po.AccountVipLog;
import com.iquizoo.manage.web.vip.service.AccountVipLogService;
import com.iquizoo.manage.web.vip.service.AccountVipService;

/**
 * 会员期限
 *
 * @author Jianxing Wen
 * @date 2016年12月5日下午6:40:46
 */
@RequestMapping("accountVip")
@Controller
public class AccountVipController extends BaseController {

    @Autowired
    private AccountVipService accountVipService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private UserService userService;
    @Autowired
    private AccountVipLogService accountVipLogService;

    /**
     * 验证当前账户是否已经是会员
     */
    @RequestMapping(value = "/validate")
    @ResponseBody
    public String validatePhone(String phone) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Account account = accountService.getByPhone(phone);
        if (account != null) {
            AccountVip accountVip = accountVipService.getByAccountId(account.getId());
            if (accountVip != null) {
                Date now = new Date();
                if (accountVip.getEndTime().getTime() >= now.getTime()) {// 未过期
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    map.put("code", 1);
                    map.put("msg", "会员到期时间：" + format.format(accountVip.getEndTime()));
                    return JSON.toJSONString(map);
                } else {
                    map.put("code", 0);
                    map.put("msg", "success");
                    return JSON.toJSONString(map);
                }
            }
            map.put("code", 0);
            map.put("msg", "success");
            return JSON.toJSONString(map);
        } else {// 当前账号没注册
            map.put("code", 2);
            map.put("msg", "当前手机号没有注册");
            return JSON.toJSONString(map);

        }

    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/list")
    public ModelAndView accountVipMV() throws Exception {
        return new ModelAndView("vip/accountVip");
    }

    /**
     * 数据展示
     *
     * @param table
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST}, value = "/list")
    public String getTable(DataTable<AccountVip> table) throws Exception {
        DataTable<AccountVipDTO> tables = accountVipService.getTable(table);
        return JSON.toJSONString(tables);
    }

    /**
     * 修改
     *
     * @param id
     * @param phone
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/edit")
    public ModelAndView editTaskMV(Integer id, String phone) throws Exception {
        ModelAndView model = new ModelAndView("vip/accountVipAdd");
        if (id != null) {
            AccountVip accountVip = accountVipService.getById(id);

            if (accountVip != null) {
                model.addObject("accountVip", accountVip);
            }
        }

        phone = phone == null ? "" : phone;
        model.addObject("phone", phone);

        return model;
    }

    /**
     * 添加会员记录
     *
     * @param param
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public String add(String param) throws Exception {
        AccountVipDTO dto = JSON.parseObject(param, AccountVipDTO.class);
        Account account = accountService.getByPhone(dto.getPhone());
        //查询当前用户是否有会员记录
        AccountVip accountVip = accountVipService.getByAccountId(account.getId());
        if (accountVip != null) {// 有记录
            Date now = new Date();
            if (accountVip.getEndTime().getTime() > now.getTime()) {// 未过期
                accountVip.setEndTime(dto.getEndTime());
                accountVipService.update(accountVip);
                // 添加日志
                Admin admin = AppContext.getAdmin();
                AccountVipLog log = new AccountVipLog(admin.getId(), accountVip.getAccountId(), new Date(), accountVip.getStartTime(), accountVip.getEndTime(), dto.getMark());
                accountVipLogService.insert(log);
            } else {
                accountVip.setAccountId(account.getId());


                // 获取账号的第一个
                User user = userService.getByAccountId(dto.getAccountId());
                if (user != null) {
                    accountVip.setUserId((int) user.getId());
                }
                accountVip.setVipId(1);
                accountVip.setStartTime(dto.getStartTime());
                accountVip.setEndTime(dto.getEndTime());
                accountVip.setCreateTime(new Date());
                accountVip.setMark(dto.getMark());
                accountVipService.insert(accountVip);

                // 添加日志
                Admin admin = AppContext.getAdmin();
                AccountVipLog log = new AccountVipLog(admin.getId(), accountVip.getAccountId(), new Date(), accountVip.getStartTime(), accountVip.getEndTime(), dto.getMark());
                accountVipLogService.insert(log);
            }
        } else {
            accountVip.setAccountId(account.getId());
            // 获取账号的第一个
            User user = userService.getByAccountId(dto.getAccountId());
            if (user != null) {
                accountVip.setUserId((int) user.getId());
            }
            accountVip.setVipId(1);
            accountVip.setStartTime(dto.getStartTime());
            accountVip.setEndTime(dto.getEndTime());
            accountVip.setCreateTime(new Date());
            accountVip.setMark(dto.getMark());
            accountVipService.insert(accountVip);

            // 添加日志
            Admin admin = AppContext.getAdmin();
            AccountVipLog log = new AccountVipLog(admin.getId(), accountVip.getAccountId(), new Date(), accountVip.getStartTime(), accountVip.getEndTime(), dto.getMark());
            accountVipLogService.insert(log);
        }

        return success();

    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST}, value = "/del")
    public String del(int id) throws Exception {
        accountVipService.delete(id);
        ;
        return success();
    }
}
