/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午11:45:48
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
package com.wiggin.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @date 2017年1月21日 下午11:45:48
 * @author wiggin
 * @Description: TODO(这里用一句话描述这个类的作用)
 * 
 */
public class StringUtils {

	/**
	 * 
	 * @date 2017年1月21日 下午11:44:48
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private StringUtils(){
		
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:46:51
	 * @author wiggin
	 * @Description: 将回车等转为空格
	 * @param str
	 * @return
	 *
	 */
	public static String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s+|\t|\r|\n");
		Matcher m = p.matcher(str);
		return m.replaceAll(" ");
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:47:34
	 * @author wiggin
	 * @Description: String 转Long 
	 * @param str
	 * @return
	 *
	 */
	public static Long strToLong(String str){
		return Long.parseLong(str);
	}
	
	/**
	 * 
	 * @date 2015年12月26日 上午10:28:55
	 * @author zhou.wenwei
	 * @Description: 判断字符串是否为空白字符
	 * @param cs
	 * @return
	 *
	 */
    public static boolean isNotBlank(CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == true) {
                return false;
            }
        }
        return true;
    }
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:52:04
	 * @author wiggin
	 * @Description: 判断字符串是否为空字符串
	 * @param str
	 * @return
	 *
	 */
	public static boolean isEmpty(String str){
		if(null == str || "".equals(str)){
			return true;
		}
		return false;
	}
}
