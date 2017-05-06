package com.iquizoo.manage.web.product.service;

import org.springframework.web.multipart.MultipartFile;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicService;
import com.iquizoo.manage.web.product.dto.PropDto;
import com.iquizoo.manage.web.product.po.Prop;

/**
 * 道具
 * @author Jianxing Wen
 * @date 2016-8-26下午3:47:59
 */
public interface PropService extends BasicService<Prop>{
	
	DataTable<PropDto> getTable(DataTable<Prop> table) throws Exception;
	String upload(MultipartFile image) throws Exception;
}
