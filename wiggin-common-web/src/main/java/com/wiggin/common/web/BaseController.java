/**
 *
 * copyright 2015-2020
 * @date 2017年1月23日 下午9:39:48
 * @author wiggin
 * @Description: 所有控制器的基类
 * 
 */
package com.wiggin.common.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @date 2017年1月23日 下午9:39:48
 * @author wiggin
 * @Description: 所有控制器的基类
 * 
 */
public abstract class BaseController {
	
	private static Logger logger = LoggerFactory.getLogger(BaseController.class);

	/**
	 * 
	 * @date 2017年1月23日 下午9:49:22
	 * @author wiggin
	 * @Description: 从请求参数中获取特定名称的参数
	 * @param request
	 * @param name
	 * @return
	 *
	 */
	protected String getParameterFromRequest(HttpServletRequest request, String name) {
		if (logger.isDebugEnabled()) {
			logger.debug("getParameterFromRequest name:{}", name);
		}
		String value = null;
		if (request.getParameter(name) != null) {
			value = request.getParameter(name).toString();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("getParameterFromRequest name:{},value:{}", name, value);
		}

		return value;
	}
}
