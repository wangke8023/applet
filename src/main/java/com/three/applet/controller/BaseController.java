package com.three.applet.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController {
	private Map<String,Object> resultMap;

	public Map<String, Object> getResultMap() {
		return new HashMap<>();
	}

	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	
}
