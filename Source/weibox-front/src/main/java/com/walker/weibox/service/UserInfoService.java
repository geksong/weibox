package com.walker.weibox.service;

import com.walker.weibox.model.UserInfo;

public interface UserInfoService {
	public UserInfo findByUserName(String userName);
}
