package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.model.UserInfo;
import com.walker.weibox.repository.UserInfoRepository;
import com.walker.weibox.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByUserName(String userName) {
		return userInfoRepository.findByUserName(userName);
	}
}
