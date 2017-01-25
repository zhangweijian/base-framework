/**
 *
 * copyright 2015-2020
 * @date 2017年1月25日 上午10:23:52
 * @author wiggin
 * @Description: 用于测试框架是否可用
 * 
 */
package com.wiggin.service;

import com.wiggin.model.Test;

/**
 *
 * @date 2017年1月25日 上午10:23:52
 * @author wiggin
 * @Description: 用于测试框架是否可用
 * 
 */
public interface TestService {

	/**
	 * 
	 * @date 2017年1月25日 上午10:26:16
	 * @author wiggin
	 * @Description: 通过id获取Test实体
	 * @param id
	 * @return
	 *
	 */
	Test qryTest(Integer id);
}
