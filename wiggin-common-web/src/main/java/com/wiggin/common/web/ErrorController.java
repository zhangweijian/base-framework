/**
 *
 * copyright 2015-2020
 * @date 2017年1月23日 下午9:54:17
 * @author wiggin
 * @Description: 错误控制器
 * 
 */
package com.wiggin.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @date 2017年1月23日 下午9:54:17
 * @author wiggin
 * @Description: 错误控制器
 * 
 */
@Controller
@RequestMapping(value = "/error", method = RequestMethod.GET)
public class ErrorController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	/**
	 * 
	 * @date 2017年1月23日 下午9:59:59
	 * @author wiggin
	 * @Description: 403错误
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 *
	 */
	@RequestMapping(value = "/403")
	public ModelAndView error403(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.error("403");
		ModelAndView page = new ModelAndView("/error/403");
		return page;
	}
	
}
