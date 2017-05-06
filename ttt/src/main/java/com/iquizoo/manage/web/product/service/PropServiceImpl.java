package com.iquizoo.manage.web.product.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iquizoo.core.page.DataTable;
import com.iquizoo.manage.web.common.service.BasicServiceImpl;
import com.iquizoo.manage.web.product.dao.PropDao;
import com.iquizoo.manage.web.product.dto.PropDto;
import com.iquizoo.manage.web.product.po.Prop;

@Service
public class PropServiceImpl extends BasicServiceImpl<Prop> implements PropService{

	@Autowired
	private PropDao propDao;
	
	@Override
	public DataTable<PropDto> getTable(DataTable<Prop> table)
			throws Exception {
		DataTable<PropDto> dtoTable = new DataTable<PropDto>();
		table = propDao.getTable(table);
		BeanUtils.copyProperties(table, dtoTable, "data");
		List<Prop> propList = table.getData();
		for(Prop prop : propList){
			PropDto dto = new PropDto();
			BeanUtils.copyProperties(prop, dto);
			if(prop.getType() == Prop.TYPE_FOOD){
				dto.setTypeName(PropDto.TYPE_FOOD);
			}else if(prop.getType() == Prop.TYPE_PET_CARD){
				dto.setTypeName(PropDto.TYPE_CARD);
			}
			if(prop.getRandom() == 0){
				dto.setRandomName(PropDto.RANDOM_FALSE);
			}else{
				dto.setRandomName(PropDto.RANDOM_TRUE);
			}
			if(prop.getSubType() == Prop.SUB_TYPE_GOLD){
				dto.setSubName(PropDto.SUB_TYPE_GOLD);
			}else{
				dto.setSubName(PropDto.SUB_TYPE_OTHER);
			}
			dtoTable.getData().add(dto);
		}
		return dtoTable;
	}

	@Override
	public String upload(MultipartFile image) throws Exception {
		String filePath = null;
		if(image != null && image.getSize() > 0){
			String fileName = image.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			String newName = "prop_img_" + System.currentTimeMillis() + suffix;
			String folder = "prop";
			//filePath = ImageTool.uploadManage2Img(folder,newName, image.getInputStream());
		}
		return filePath;
	}
	

}
