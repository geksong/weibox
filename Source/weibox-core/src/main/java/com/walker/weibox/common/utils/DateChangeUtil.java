package com.walker.weibox.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 * author geksong <br/>
 * function 日期格式转换<br/>
 **/
public class DateChangeUtil {
	private static final Log log = LogFactory.getLog(DateChangeUtil.class);
	/**
	 * 获取指定格式的时间
	 * @param date
	 * @param datePattern
	 * @return
	 */
	public static String convertDateToString(Date date, String datePattern) {
		if(null == date)
			return "";
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		return sdf.format(date);
	}
	
	/**
	 * 从字符串转到时间
	 * @param dateStr
	 * @param datePattern
	 * @return
	 */
	public static Date convertStringToDate(String dateStr, String datePattern) {
		if(StringUtils.isBlank(dateStr))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error(e);
			return null;
		}
		return date;
	}
	
	/**
	 * 获取秒数表示的时间
	 * @param date
	 * @return
	 */
	public static int getDateSeconds(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		long sec = calendar.getTimeInMillis() / 1000L;
		return (int)sec;
	}
	
	/**
	 * 将秒数格式时间转换为date
	 * @param seconds
	 * @return
	 */
	public static Date convertSecondToDate(int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(seconds * 1000L);
		return calendar.getTime();
	}
}