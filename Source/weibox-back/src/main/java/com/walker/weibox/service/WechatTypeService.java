package com.walker.weibox.service;

import org.springframework.data.domain.Page;

import com.walker.weibox.model.WechatType;

public interface WechatTypeService {
	public Page<WechatType> pagination(int page);
	public void add(WechatType wechatType);
}
