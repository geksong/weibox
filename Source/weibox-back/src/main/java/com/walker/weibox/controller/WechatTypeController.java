package com.walker.weibox.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		Page<WechatType> wechatTypePage = wechatTypeService.pagination(page);
		model.addAttribute("pageList", wechatTypePage);
		model.addAttribute("page", page);
		return "/WEB-INF/back/wechattype/wechattype-list";
	}
	
	@RequestMapping("toadd")
	public String toAdd(Model model) {
		return "/WEB-INF/back/wechattype/wechattype-add";
	}
	@RequestMapping("add")
	public ModelAndView add(@RequestParam(value="wechatTypeName") String wechatTypeName) {
		ModelAndView jsonView = getDefaultJSONView();
		if(StringUtils.isBlank(wechatTypeName)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "请填写类型名称");
			return jsonView;
		}
		WechatType wechatType = new WechatType();
		wechatType.setWechatTypeName(wechatTypeName);
		wechatTypeService.addOrUpdate(wechatType);
		jsonView.addObject("msg", "添加成功");
		return jsonView;
	}
	
	@RequestMapping("toupdate")
	public String toUpdate(@RequestParam(value="id") int id, Model model) {
		WechatType wechatType = wechatTypeService.findById(id);
		model.addAttribute("wechatType", wechatType);
		return "/WEB-INF/back/wechattype/wechattype-update";
	}
	
	@RequestMapping("update")
	public ModelAndView update(@RequestParam(value="id") int id,
			@RequestParam(value="wechatTypeName") String wechatTypeName) {
		ModelAndView jsonView = getDefaultJSONView();
		if(StringUtils.isBlank(wechatTypeName)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "请填写类型名称");
			return jsonView;
		}
		WechatType wechatType = new WechatType();
		wechatType.setId(id);
		wechatType.setWechatTypeName(wechatTypeName);
		wechatTypeService.addOrUpdate(wechatType);
		jsonView.addObject("msg", "更新成功");
		return jsonView;
	}
	
	@RequestMapping("del")
	public ModelAndView del(@RequestParam(value="id") int id) {
		ModelAndView jsonView = getDefaultJSONView();
		wechatTypeService.del(id);
		return jsonView;
	}
}
