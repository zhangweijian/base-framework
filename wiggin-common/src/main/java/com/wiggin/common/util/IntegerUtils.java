/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午11:42:51
 * @author wiggin
 * @Description: Integer工具集
 * 
 */
package com.wiggin.common.util;

/**
 *
 * @date 2017年1月21日 下午11:42:51
 * @author wiggin
 * @Description: Integer工具集
 * 
 */
public class IntegerUtils {
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:43:12
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private IntegerUtils() {
	}

	/**
	 * 
	 * @date 2017年1月21日 下午11:43:32
	 * @author wiggin
	 * @Description:  Object 转换为 Integer
	 * @param value
	 * @return
	 *
	 */
	public static Integer valueOf(Object value) {
		Integer res = null;
		if (value != null && value.toString().trim().length() > 0) {
			res = Integer.valueOf(value.toString().trim());
		}
		return res;
	}

}
