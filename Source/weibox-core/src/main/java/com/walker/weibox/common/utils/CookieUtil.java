package com.walker.weibox.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.walker.weibox.common.constants.DatePattern;
import com.walker.weibox.model.LoginUser;

/**
 * author geksong <br/>
 * function <br/>
 **/
public class CookieUtil {
	private static final Log log = LogFactory.getLog(CookieUtil.class);
	private static final CookieUtil cookieUtil = new CookieUtil();
	/**
	 * 行者后台用户cookie存储健
	 */
	private static final String USER_BACK_COOKIE_KEY = "_xz_bu";
	/**
	 * 行者前台用户cookie存储键
	 */
	private static final String USER_FRONT_COOKIE_KEY = "_xz_fu";
	/**
	 * 行者后台用户加解密密钥
	 */
	private static final String USER_BACK_CODE_KEY = "xingzhe#3743buck";
	/**
	 * 行者前台用户加解密密钥
	 */
	private static final String USER_FRONT_CODE_KEY = "xingzhe$3742fuck";
	
	private static final String SPLIT = "||";
	
	private CookieUtil() {
		
	}
	
	public static CookieUtil instance() {
		return cookieUtil;
	}
	
	/**
	 * 获取域名
	 * @param req
	 * @return
	 */
	public String getDomain(HttpServletRequest req) {
		String serverName = req.getServerName();
		String domain = StringUtils.substring(serverName, StringUtils.indexOf(serverName, "."));
		return domain;
	}
	
	/**
	 * 写入cookie
	 * @param cookieKey
	 * @param cookieValue
	 * @param rep
	 */
	private void saveCookie(String cookieKey, String cookieValue, HttpServletRequest req, HttpServletResponse rep) {
		Cookie cookie = new Cookie(cookieKey, cookieValue);
		cookie.setDomain(getDomain(req));
		cookie.setPath("/");
		cookie.setMaxAge(-1);
		cookie.setSecure(false);
		rep.addCookie(cookie);
	}
	
	/**
	 * 存入后台登陆用户
	 * @param user
	 * @param req
	 * @param rep
	 */
	public void saveBackUser(LoginUser user, HttpServletRequest req, HttpServletResponse rep) {
		saveUser(user, req, rep, USER_BACK_CODE_KEY, USER_BACK_COOKIE_KEY);
	}
	
	/**
	 * 存入前台登陆用户
	 * @param user
	 * @param req
	 * @param rep
	 */
	public void saveFrontUser(LoginUser user, HttpServletRequest req, HttpServletResponse rep) {
		saveUser(user, req, rep, USER_FRONT_CODE_KEY, USER_FRONT_COOKIE_KEY);
	}
	
	/**
	 * 获取后台登陆用户
	 * @param reqn
	 * @return
	 */
	public LoginUser getBackUser(HttpServletRequest req) {
		return parseUser(req, USER_BACK_CODE_KEY, USER_BACK_COOKIE_KEY);
	}
	
	/**
	 * 获取前台登陆用户
	 * @param req
	 * @return
	 */
	public LoginUser getFrontUser(HttpServletRequest req) {
		return parseUser(req, USER_FRONT_CODE_KEY, USER_FRONT_COOKIE_KEY);
	}
	
	/**
	 * 后台用户是否登陆
	 * @param req
	 * @return
	 */
	public boolean isBackLogin(HttpServletRequest req) {
		LoginUser user = getBackUser(req);
		if(null == user)
			return false;
		return true;
	}
	
	/**
	 * 前台用户是否登陆
	 * @param req
	 * @return
	 */
	public boolean isFrontLogin(HttpServletRequest req) {
		LoginUser user = getFrontUser(req);
		if(null == user)
			return false;
		return true;
	}
	
	private void saveUser(LoginUser user, HttpServletRequest req, HttpServletResponse rep, String codeKey, String cookieKey) {
		if(null == user) {
			log.info("用户为空，不写cookie");
			return ;
		}
		String nowDate = DateChangeUtil.convertDateToString(new Date(), DatePattern.YYYYMMDDHHMMSS);
		StringBuilder userSb = new StringBuilder();
		userSb.append(user.getUserName()).append("||").append(user.getUserId()).append("||")
			.append(nowDate);
		String cookieValue = "";
		try {
			cookieValue = AESUtil.encrypt(userSb.toString(), codeKey);
		} catch (Exception e) {
			log.error("用户信息加密错误：" + e);
		}
		if(StringUtils.isNotBlank(cookieValue)) {
			try {
				cookieValue = URLEncoder.encode(cookieValue, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				log.error(e);
			}
			saveCookie(cookieKey, cookieValue, req, rep);
		}else {
			log.info("用户信息加密之后为空，不写cookie");
		}
	}
	
	private LoginUser parseUser(HttpServletRequest req, String codeKey, String cookieKey) {
		Cookie[] cookies = req.getCookies();
		Cookie cookie = null;
		for(Cookie ck : cookies) {
			if(cookieKey.equals(ck.getName())) {
				cookie = ck;
				break;
			}
		}
		if(null == cookie) {
			return null;
		}
		String cookieValue = cookie.getValue();
		try {
			cookieValue = URLDecoder.decode(cookieValue, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		String decodeValue = "";
		try {
			decodeValue = AESUtil.decrypt(cookieValue, codeKey);
		} catch (Exception e) {
			log.error("用户信息解密错误：" + e);
		}
		String[] values = StringUtils.split(decodeValue, SPLIT);
		LoginUser user = new LoginUser();
		user.setUserName(values[0]);
		user.setUserId(values[1]);
		return user;
	}
}
