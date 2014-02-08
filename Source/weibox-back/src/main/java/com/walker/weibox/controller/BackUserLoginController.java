package com.walker.weibox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walker.weibox.common.utils.CookieUtil;
import com.walker.weibox.model.BackUser;
import com.walker.weibox.model.LoginUser;
import com.walker.weibox.service.BackUserService;

/**
 * author geksong <br/>
 * function 后台用户登陆<br/>
 **/
@Controller
@RequestMapping("/backuser")
public class BackUserLoginController extends BaseBackController {
	@Autowired
	private BackUserService backUserService;
	/**
	 * 登陆跳传
	 * @param userName
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("login")
	public ModelAndView login(@RequestParam(value="userName") String userName,
			@RequestParam(value="password") String password,
			@RequestParam(value="jumpUrl", defaultValue="/back/flowsolution/list.do", required=false) String jumpUrl,
			HttpServletRequest req, HttpServletResponse rep) {
		ModelAndView jsonView = getDefaultJSONView();
		if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户名或密码为空");
			return jsonView;
		}
		BackUser buser = backUserService.findByUserName(userName);
		if(null == buser) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "用户不存在");
			return jsonView;
		}
		if(!password.equals(buser.getUserPassword())) {
			jsonView.addObject("code", false);
			jsonView.addObject("msg", "密码错误");
			return jsonView;
		}
		LoginUser user = new LoginUser();
		user.setUserName(buser.getUserName());
		user.setUserId(String.valueOf(buser.getId()));
		CookieUtil.instance().saveBackUser(user, req, rep);
		jsonView.addObject("code", true);
		jsonView.addObject("msg", "登陆成功");
		jsonView.addObject("jumpUrl", jumpUrl);
		return jsonView;
	}
	
	/**
	 * 后台用户退出
	 * @param req
	 * @param rep
	 * @param model
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest req, HttpServletResponse rep, Model model) {
		if(CookieUtil.instance().isBackLogin(req)) {
			CookieUtil.instance().removeBackUser(req, rep);
		}
		return "/welcome";
	}
}
