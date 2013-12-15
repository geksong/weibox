package com.walker.weibox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.walker.weibox.service.WechatTypeService;

/**
 * 微信公众帐号类型管理后台
 * @author geksong
 *
 */
@Controller
public class WechatTypeController extends BaseBackController {
	@Autowired
	private WechatTypeService wechatTypeService;
	
	public String list() {
		return "";
	}
}
