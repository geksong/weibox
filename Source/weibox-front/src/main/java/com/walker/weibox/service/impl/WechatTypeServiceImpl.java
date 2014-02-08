package com.walker.weibox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.walker.weibox.common.constants.Constants;
import com.walker.weibox.model.WechatType;
import com.walker.weibox.repository.WechatTypeRepository;
import com.walker.weibox.service.WechatTypeService;

@Service("wechatTypeService")
public class WechatTypeServiceImpl implements WechatTypeService {
	@Autowired
	private WechatTypeRepository wechatTypeRepository;

	@Override
	public Page<WechatType> pagination(int page) {
		page -= 1;
		return wechatTypeRepository.findAll(new PageRequest(page, Constants.BACK_PAGE_SIZE));
	}

	@Override
	public void addOrUpdate(WechatType wechatType) {
		wechatTypeRepository.save(wechatType);
	}

	@Override
	public WechatType findById(int id) {
		return wechatTypeRepository.findOne(id);
	}

	@Override
	public void del(int id) {
		wechatTypeRepository.delete(id);
	}
}
