package com.iquizoo.manage.base.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.iquizoo.manage.base.context.AppContext;
import com.iquizoo.manage.web.admin.po.Resource;
import com.iquizoo.manage.web.admin.service.ResourceService;

@Component
public class ServerInit implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private ResourceService resourceService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		try {
			List<Resource> a = resourceService.getResourceCategory();
			AppContext.setCategory(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
