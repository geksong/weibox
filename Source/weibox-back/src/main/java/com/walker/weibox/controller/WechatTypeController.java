package com.walker.weibox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.walker.weibox.model.WechatType;
import com.walker.weibox.service.WechatTypeService;

/**
 * 微信公众帐号类型管理后台
 * @author geksong
 *
 */
@Controller
@RequestMapping("/back/wechattype")
public class WechatTypeController extends BaseBackController {
	@Autowired
	private WechatTypeService wechatTypeService;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="page", defaultValue="1", required=false) int page,
			Model model) {
		if(page <= 0)
			page = 1;
		Page<WechatType> wechatTypePage = wechatTypeService.pagination(1);
		model.addAttribute("pageList", wechatTypePage);
		return "/WEB-INF/back/wechattype/wechattype-list";
	}
}
