package com.walker.weibox.common.utils;
/**
 * author geksong <br/>
 * function 数据验证工具<br/>
 **/
public class DataValidateUtil {
	private DataValidateUtil() {
		
	}
	
	/**
	 * string是否是合适的用户名
	 * @param validString
	 * @return
	 */
	public static boolean isAllowUserName(String validString) {
		if(null == validString || validString.equals(""))
			return false;
		if(validString.matches("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$"))
			return true;
		return false;
	}
	
	/**
	 * 是否是合法的密码
	 * @param validString
	 * @return
	 */
	public static boolean isAllowPassword(String validString) {
		if(null == validString || validString.equals(""))
			return false;
		if(validString.matches("^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$"))
			return true;
		return false;
	}
}
