package com.walker.weibox.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController {
	private static ObjectMapper mapper = new ObjectMapper();
	@Value("${static.path}")
	protected String staticPath;
	
	/**
	 * 返回默认携带code=true的modelview
	 * @return
	 */
	protected ModelAndView getDefaultJSONView() {
		ModelAndView model = new ModelAndView("jsonView");
		model.addObject("code", true);
		return model;
	}
}
