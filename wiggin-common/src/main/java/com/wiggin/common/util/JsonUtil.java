/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午9:12:21
 * @author wiggin
 * @Description: 把对json字符串的操作封装成静态方法,使用jackson处理
 * 
 */
package com.wiggin.common.util;


import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @date 2017年1月21日 下午9:12:21
 * @author wiggin
 * @Description: 把对json字符串的操作封装成静态方法,使用jackson处理
 * 
 */
public class JsonUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static ObjectMapper mapper = new ObjectMapper().setDateFormat(dateFormat);
	
	private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:40:30
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private JsonUtil(){
		
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午10:31:14
	 * @author wiggin
	 * @Description: 将对象转成json
	 * @param object
	 * @return
	 *
	 */
	public static String toJsonString(Object object){
		String json = null;
		
		if ( object == null ) {
			throw new RuntimeException("对象转字符串失败：对象为空。");
		} else {
			try {
				json = mapper.writeValueAsString(object);
			} catch (Exception e) {
				logger.error("toJsonStringException :{}",e);
			}
		}
		
		return json == null ? "":json;
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午10:31:28
	 * @author wiggin
	 * @Description: 将json转成对象
	 * @param jsonStr
	 * @param classOfT
	 * @return
	 *
	 */
	public static <T> T toObject(String jsonStr, Class<T> classOfT) {
		
		try {
			return mapper.readValue(jsonStr, classOfT);
		} catch (Exception e) {
			logger.error("toObjectException :{}",e);
		}
		return null;
	}
}
