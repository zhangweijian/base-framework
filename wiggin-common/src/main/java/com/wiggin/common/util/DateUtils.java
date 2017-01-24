/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午11:17:49
 * @author wiggin
 * @Description:  Date 工具类
 * 
 */
package com.wiggin.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @date 2017年1月21日 下午11:17:49
 * @author wiggin
 * @Description: Date 工具类
 * 
 */
public class DateUtils {

	/**
	 * 
	 * @date 2017年1月21日 下午11:40:30
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private DateUtils(){
		
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:18:45
	 * @author wiggin
	 * @Description: 获取当前系统时间
	 * @return
	 *
	 */
	public static Date now() {
		long t0 = System.currentTimeMillis();
		Date now = new Date(t0);
		return now;
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:19:26
	 * @author wiggin
	 * @Description: 返回默认格式的时间字符串，默认格式为：yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 *
	 */
	public static String defaultFormatDate(Date date) {
		String str = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = sdf.format(date);
		
		return str;
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:19:56
	 * @author wiggin
	 * @Description: 返回指定格式的时间字符串
	 * @param date
	 * @param pattern
	 * @return
	 *
	 */
	public static String formatDate(Date date, String pattern) {
		String str = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		str = sdf.format(date);
		
		return str;
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:21:32
	 * @author wiggin
	 * @Description: 比较两个日期大小
	 * 0：相等、正数date1大、负数date2大
	 * @param date1
	 * @param date2
	 * @return
	 *
	 */
	public static long compare(Date date1, Date date2) {
		if(date1 == null && date2 == null) {
			return 0;
		}
		if(date1 == null) {
			return -1;
		}
		if(date2 == null) {
			return 1;
		}
		return date1.getTime() - date2.getTime();
	}
}
