package com.walker.weibox.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.walker.weibox.common.utils.CookieUtil;

/**
 * author geksong <br/>
 * function 后台登陆拦截器<br/>
 **/
@Component("backLoginInterceptor")
public class BackLoginInterceptor implements HandlerInterceptor {
	private Log log = LogFactory.getLog(BackLoginInterceptor.class);
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		log.info("拦截器执行..........................");
		if(!CookieUtil.instance().isBackLogin(arg0)) {
			arg1.sendRedirect("/welcome.jsp");
			return false;
		}
		return true;
	}
	
}
