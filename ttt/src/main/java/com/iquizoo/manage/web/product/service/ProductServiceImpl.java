package com.iquizoo.manage.web.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.Constants;
import com.iquizoo.manage.web.common.Status;
import com.iquizoo.manage.web.product.dao.ProductDao;
import com.iquizoo.manage.web.product.dto.ProductDto;
import com.iquizoo.manage.web.product.po.Product;

/**
 * 商品
 * 
 * @author Jianxing Wen
 * @date 2016-7-5上午11:47:51
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public DataTable<ProductDto> getTable(DataTable<Product> table)
			throws Exception {

		DataTable<ProductDto> dtoTable = new DataTable<ProductDto>();
		List<Product> productList = productDao.getTable(table).getData();// 得到数据
		BeanUtils.copyProperties(table, dtoTable,"data");//赋值所有属性
		for (Product product : productList) {
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(product, dto);
			if (product.getType() == 1) {
				dto.setTypeName(Constants.TYPE_VIP);
			} else if (product.getType() == 2) {
				dto.setTypeName(Constants.TYPE_GOLD);
			}
			if (product.getStatus() == 1) {
				dto.setStatusName(Constants.STATUS_NORMAL);
			} else if (product.getStatus() == 0) {
				dto.setStatusName(Constants.STATUS_NOTUSE);
			}
			if (product.getCode() == 1) {
				dto.setCodeName(Constants.CODE_VIP);
			} else if (product.getCode() == 0) {
				dto.setCodeName(Constants.CODE_GOLD);
			}
			dtoTable.getData().add(dto);
		}

		return dtoTable;
	}

	@Override
	public ProductDto getById(int id) throws Exception {
		// TODO Auto-generated method stub
		Product product = productDao.getById(id);
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties(product, productDto);
		if (product.getType() == 1) {
			productDto.setTypeName(Constants.TYPE_VIP);
		} else if (product.getType() == 2) {
			productDto.setTypeName(Constants.TYPE_GOLD);
		}
		if (product.getStatus() == 1) {
			productDto.setStatusName(Constants.STATUS_NORMAL);
		} else if (product.getStatus() == 0) {
			productDto.setStatusName(Constants.STATUS_NOTUSE);
		}
		if (product.getCode() == 1) {
			productDto.setCodeName(Constants.CODE_VIP);
		} else if (product.getCode() == 0) {
			productDto.setCodeName(Constants.CODE_GOLD);
		}
		return productDto;
	}

	@Override
	public void addProduct(String params) throws Exception {
		// TODO Auto-generated method stub

		Product pro = JSON.parseObject(params, Product.class);
		productDao.addProduct(pro);
	}

	@Override
	public void updateProduct(String params) throws Exception {
		// TODO Auto-generated method stub
		Product pro = JSON.parseObject(params, Product.class);
		productDao.updateProduct(pro);
	}

	@Override
	public void delProduct(int id) throws Exception {
		// TODO Auto-generated method stub
		productDao.delProduct(id);
	}

	@Override
	public List<ProductDto> getList() throws Exception {
		// TODO Auto-generated method stub
		List<Product> productList = productDao.getList();
		List<ProductDto> dtoList = new ArrayList<ProductDto>();
		BeanUtils.copyProperties(productList, dtoList);

		for (Product product : productList) {
			ProductDto dto = new ProductDto();
			BeanUtils.copyProperties(product, dto);
			if (product.getType() == 1) {
				dto.setTypeName(Constants.TYPE_VIP);
			} else if (product.getType() == 2) {
				dto.setTypeName(Constants.TYPE_GOLD);
			}
			if (product.getStatus() == 1) {
				dto.setStatusName(Constants.STATUS_NORMAL);
			} else if (product.getStatus() == 0) {
				dto.setStatusName(Constants.STATUS_NOTUSE);
			}
			if (product.getCode() == 1) {
				dto.setCodeName(Constants.CODE_VIP);
			} else if (product.getCode() == 0) {
				dto.setCodeName(Constants.CODE_GOLD);
			}
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public List<Status> setStatus() throws Exception {
		// TODO Auto-generated method stub
		List<Status> statusList = new ArrayList<Status>();
		Status status = new Status();
		status.setStatus(1);
		status.setStatusName("正常");
		statusList.add(status);
		
		status = new Status();
		status.setStatus(0);
		status.setStatusName("下架");
		statusList.add(status);
		return statusList;
	}

	@Override
	public List<Status> setType() throws Exception {
		// TODO Auto-generated method stub
		List<Status> statusList = new ArrayList<Status>();
		Status status = new Status();
		status.setStatus(1);
		status.setStatusName("会员");
		statusList.add(status);
		status = new Status();
		status.setStatus(0);
		status.setStatusName("栗子");
		statusList.add(status);
		return statusList;
	}

	@Override
	public List<Status> setCode() throws Exception {
		// TODO Auto-generated method stub
		List<Status> statusList = new ArrayList<Status>();
		Status status = new Status();
		status.setStatus(1);
		status.setStatusName("VIP");
		statusList.add(status);
		status = new Status();
		status.setStatus(2);
		status.setStatusName("高级VIP");
		statusList.add(status);
		status = new Status();
		status.setStatus(0);
		status.setStatusName("栗子");
		statusList.add(status);
		return statusList;
	}

}
