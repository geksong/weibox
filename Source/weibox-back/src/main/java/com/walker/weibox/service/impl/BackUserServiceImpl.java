package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.model.BackUser;
import com.walker.weibox.repository.BackUserRepository;
import com.walker.weibox.service.BackUserService;

/**
 * author geksong <br/>
 * function <br/>
 **/
@Service("backUserService")
public class BackUserServiceImpl implements BackUserService {
	@Autowired
	private BackUserRepository backUserRepository;
	@Override
	public BackUser findByUserName(String userName) {
		return backUserRepository.findByUserName(userName);
	}

}
