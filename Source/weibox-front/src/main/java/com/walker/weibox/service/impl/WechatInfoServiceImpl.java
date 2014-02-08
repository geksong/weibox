package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.repository.WechatInfoRepository;
import com.walker.weibox.service.WechatInfoService;

@Service("wechatInfoService")
public class WechatInfoServiceImpl implements WechatInfoService {
	@Autowired
	private WechatInfoRepository wechatInfoRepository;
}
