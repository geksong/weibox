package com.walker.weibox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walker.weibox.common.utils.ChinaStringUtil;
import com.walker.weibox.common.utils.CookieUtil;
import com.walker.weibox.common.utils.DataValidateUtil;
import com.walker.weibox.model.LoginUser;
import com.walker.weibox.model.UserInfo;
import com.walker.weibox.service.UserInfoService;

/**
 * author geksong <br/>
 * function 微盒子用户登陆<br/>
 **/
@Controller
@RequestMapping("/frontuser")
public class FrontLoginController extends BaseFrontController {
	@Autowired
	private UserInfoService userInfoService;
	public ModelAndView reg(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password,
			@RequestParam(value="cfmPassword") String cfmPassword,
			@RequestParam(value="jumpUrl",defaultValue="/",required=false) String jumpUrl,
			HttpServletRequest req, HttpServletResponse rep) {
		ModelAndView jsonView = getDefaultJSONView();
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)
				|| StringUtils.isBlank(cfmPassword)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名和密码不能为空");
			return jsonView;
		}
		return null;
	}
	@RequestMapping("login")
	public ModelAndView login(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password,
			@RequestParam(value="jumpUrl", defaultValue="/", required=false) String jumpUrl,
			HttpServletRequest req, HttpServletResponse rep) {
		ModelAndView jsonView = getDefaultJSONView();
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名或密码不能为空");
			return jsonView;
		}
		if(ChinaStringUtil.length(userName) > 16 || ChinaStringUtil.length(userName) < 4) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名只能是4~16个字符");
			return jsonView;
		}
		if(ChinaStringUtil.length(password) > 32 || ChinaStringUtil.length(password) < 8) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户密码只能是8~32个字符");
			return jsonView;
		}
		if(!DataValidateUtil.isAllowUserName(userName)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名只能含中文，数字，字母，或下划线，且不能以下划线开头或结尾");
			return jsonView;
		}
		if(!DataValidateUtil.isAllowPassword(password)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "密码只能含数字,字母，或下划线，且不能以下划线开头或结尾");
			return jsonView;
		}
		UserInfo userInfo = userInfoService.findByUserName(userName);
		if(null == userInfo) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名不存在");
			return jsonView;
		}
		String gistPassword = DigestUtils.md5Hex(password);
		if(!userInfo.getUserPassword().equals(gistPassword)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "密码错误");
			return jsonView;
		}
		LoginUser loginUser = new LoginUser();
		loginUser.setUserId(userInfo.getUserId());
		loginUser.setUserName(userInfo.getUserName());
		CookieUtil.instance().saveFrontUser(loginUser, req, rep);
		jsonView.addObject("code", true);
		jsonView.addObject("msg", "登陆成功");
		jsonView.addObject("jumpUrl", jumpUrl);
		return jsonView;
	}
}
