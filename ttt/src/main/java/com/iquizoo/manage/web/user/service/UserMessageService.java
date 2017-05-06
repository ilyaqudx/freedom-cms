package com.iquizoo.manage.web.user.service;

import java.util.List;

public interface UserMessageService {

	void addMessage(List<Integer> ids, String title, String content, int type) throws Exception;

}
