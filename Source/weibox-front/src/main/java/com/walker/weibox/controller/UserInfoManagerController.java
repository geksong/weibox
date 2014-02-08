package com.walker.weibox.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.walker.weibox.common.utils.CookieUtil;
import com.walker.weibox.model.LoginUser;
import com.walker.weibox.model.UserInfo;
import com.walker.weibox.service.UserInfoService;

/**
 * author geksong <br/>
 * function 用户信息自助管理<br/>
 **/
@Controller
@RequestMapping("/front/selfman")
public class UserInfoManagerController extends BaseFrontController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("touiman")
	public String toUserInfoMan(HttpServletRequest req, Model model) {
		LoginUser loginUser = CookieUtil.instance().getFrontUser(req);
		UserInfo user = userInfoService.findByUserName(loginUser.getUserName());
		model.addAttribute("user", user);
		return "/front/uiman.jsp";
	}
}
