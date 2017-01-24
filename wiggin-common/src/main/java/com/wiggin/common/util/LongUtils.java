/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午11:41:31
 * @author wiggin
 * @Description: Long工具集
 * 
 */
package com.wiggin.common.util;

/**
 *
 * @date 2017年1月21日 下午11:41:31
 * @author wiggin
 * @Description: Long工具集
 * 
 */
public class LongUtils {
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:41:56
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private LongUtils() {
	}

	/**
	 * 
	 * @date 2017年1月21日 下午11:42:13
	 * @author wiggin
	 * @Description:  Object 转换为 Long
	 * @param value
	 * @return
	 *
	 */
	public static Long valueOf(Object value) {
		Long res = null;
		if (value != null && value.toString().trim().length() > 0) {
			res = Long.valueOf(value.toString().trim());
		}
		return res;
	}
}
