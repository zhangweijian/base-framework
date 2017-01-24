/**
 *
 * copyright 2015-2020
 * @date 2017年1月21日 下午11:43:54
 * @author wiggin
 * @Description: Object 工具集	
 * 
 */
package com.wiggin.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @date 2017年1月21日 下午11:43:54
 * @author wiggin
 * @Description: Object 工具集
 * 
 */
public class ObjectUtils {

	/**
	 * 
	 * @date 2017年1月21日 下午11:44:48
	 * @author wiggin
	 * @Description: 构造私有
	 *
	 */
	private ObjectUtils(){
		
	}
	
	/**
	 * 
	 * @date 2017年1月21日 下午11:45:05
	 * @author wiggin
	 * @Description: 对象转byte数组
	 * @param object
	 * @return
	 * @throws Exception
	 *
	 */
	public static byte[] toByteArray(Object object) throws Exception {
		if(object == null) {
			return null;
		}
		byte[] bytes = null;
		ByteArrayOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
			bos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(bos);
			oos.writeObject(object);
			oos.flush();
			bytes = bos.toByteArray();
		}  finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (bos != null) {
					bos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return bytes;
	}

	/**
	 * 
	 * @date 2017年1月21日 下午11:55:23
	 * @author wiggin
	 * @Description: byte数组转对象
	 * @param bytes
	 * @return
	 * @throws Exception
	 *
	 */
	public static Object toObject(byte[] bytes) throws Exception {
		if(bytes == null) {
			return null;
		}
		Object obj = null;
		ByteArrayInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			bis = new ByteArrayInputStream(bytes);
			ois = new ObjectInputStream(bis);
			obj = ois.readObject();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
		return obj;
	}
}
