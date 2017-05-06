package com.iquizoo.manage.web.product.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.Status;
import com.iquizoo.manage.web.product.dao.ProductDao;
import com.iquizoo.manage.web.product.dao.ProductOrderDao;
import com.iquizoo.manage.web.product.dto.ProductOrderDto;
import com.iquizoo.manage.web.product.po.Product;
import com.iquizoo.manage.web.product.po.ProductOrder;
import com.iquizoo.manage.web.user.po.Account;
import com.iquizoo.manage.web.user.po.User;
import com.iquizoo.manage.web.user.service.AccountService;
import com.iquizoo.manage.web.user.service.UserService;

/**
 * 商品订单
 * 
 * @author Jianxing Wen
 * @date 2016-7-6下午2:23:39
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

	@Autowired
	private ProductOrderDao orderDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserService userService;
	@Autowired
	private AccountService accountService;

	@Override
	public DataTable<ProductOrderDto> getTable(DataTable<ProductOrder> table)
			throws Exception {

		String phone = (String) table.getParams().get("phone");
		if(phone != null){
			// 查找账号
			Account account = accountService.getByPhone(phone);
			if(account != null){
				table.getParams().put("accountId", account.getId());
			}
		}
		DataTable<ProductOrderDto> dtoTable = new DataTable<ProductOrderDto>();
		// 得到数据
		List<ProductOrder> orderList = orderDao.getTable(table).getData();
		List<Product> productList = productDao.getList();
		BeanUtils.copyProperties(table, dtoTable, "data");// 赋值属性

		for (ProductOrder order : orderList) {
			ProductOrderDto orderDto = new ProductOrderDto();
			BeanUtils.copyProperties(order, orderDto);// 赋值属性
			for (Product product : productList) {
				if (order.getProductId() == product.getId()) {
					orderDto.setProductName(product.getName());// 赋值
				}
			}
			voluation(order, orderDto); // 赋值
			// 电话号码
			String phone1 = accountService.getPhoneById(order.getAccountId());
			orderDto.setPhone(phone1);
			dtoTable.getData().add(orderDto);// 得到dto数据
		}
		return dtoTable;
	}

	/**
	 * 赋值
	 * 
	 * @param order
	 * @param orderDto
	 * @throws Exception
	 */
	public void voluation(ProductOrder order, ProductOrderDto orderDto)
			throws Exception {
		// 查找用户名
		User user = userService.getById(order.getUserId());
		if(user != null){
			if(user.getName() != null || !"".equals(user.getName())){
				orderDto.setUserName(user.getName());
			}
		}else{
			orderDto.setUserName("");
		}
		if (order.getStatus() == ProductOrder.STATUS_PROCESSING) {
			orderDto.setStatusName(ProductOrderDto.STATUS_PROCESSING);
		} else if (order.getStatus() == ProductOrder.STATUS_SUCCESS) {
			orderDto.setStatusName(ProductOrderDto.STATUS_SUCCESS);
		} else if (order.getStatus() == ProductOrder.STATUS_FAILED) {
			orderDto.setStatusName(ProductOrderDto.STATUS_FAILED);
		}
		if (order.getClient() == ProductOrder.CLIENT_ANDROID) {
			orderDto.setClientName(ProductOrderDto.CLIENT_ANDROID);
		} else if (order.getClient() == ProductOrder.CLIENT_IOS) {
			orderDto.setClientName(ProductOrderDto.CLIENT_IOS);
		}
		if (order.getPayType() == ProductOrder.PAYTYPE_ALI) {
			orderDto.setPayTypeName(ProductOrderDto.PAYTYPE_ALI);
		} else if (order.getPayType() == ProductOrder.PAYTYPE_APPLE) {
			orderDto.setPayTypeName(ProductOrderDto.PAYTYPE_APPLE);
		}
	}

	/**
	 * 状态 list
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Status> getStatus() throws Exception {
		List<Status> statusList = new ArrayList<Status>();
		Status status = new Status();

		status.setStatus(ProductOrder.STATUS_PROCESSING);
		status.setStatusName(ProductOrderDto.STATUS_PROCESSING);
		statusList.add(status);
		status = new Status();
		status.setStatus(ProductOrder.STATUS_SUCCESS);
		status.setStatusName(ProductOrderDto.STATUS_SUCCESS);
		statusList.add(status);
		status = new Status();
		status.setStatus(ProductOrder.STATUS_FAILED);
		status.setStatusName(ProductOrderDto.STATUS_FAILED);
		statusList.add(status);

		return statusList;
	}

	@Override
	public ProductOrder getById(int id) throws Exception {
		ProductOrder order = orderDao.getById(id);
		return order;
	}

	@Override
	public void updateProductOrder(ProductOrder order) throws Exception {
		if (order.getStatus() == 1) {
			order.setUpdateTime(new Date());
		}
		orderDao.updateProductOrder(order);
	}

}
