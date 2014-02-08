package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walker.weibox.repository.WechatMsgRepository;
import com.walker.weibox.service.WechatMsgService;

@Service("wechatMsgService")
public class WechatMsgServiceImpl implements WechatMsgService {
	@Autowired
	private WechatMsgRepository wechatMsgRepository;
}
