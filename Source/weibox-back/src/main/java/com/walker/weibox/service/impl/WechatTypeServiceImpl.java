package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.repository.WechatTypeRepository;
import com.walker.weibox.service.WechatTypeService;

@Service("wechatTypeService")
public class WechatTypeServiceImpl implements WechatTypeService {
	@Autowired
	private WechatTypeRepository wechatTypeRepository;
}
