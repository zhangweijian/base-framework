/**
 *
 * copyright 2015-2020
 * @date 2017年1月28日 上午1:04:32
 * @author wiggin
 * @Description: 加载配置文件工具类
 * 
 */
package com.wiggin.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @date 2017年1月28日 上午1:04:32
 * @author wiggin
 * @Description: 加载配置文件工具类
 * 
 */
public class PropertiesUtils {

	/**
	 * 
	 * @date 2017年1月28日 上午1:05:19
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private PropertiesUtils() {

	}

	/**
	 * 
	 * @date 2017年1月28日 上午1:05:40
	 * @author wiggin
	 * @Description: Properties文件读取
	 * @param filePath classpath下的路径
	 * @return
	 *
	 */
	public static Properties loadProperties(String filePath) {
		InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(filePath);
		Properties p = new Properties();
		try {
			p.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p;
	}
}
