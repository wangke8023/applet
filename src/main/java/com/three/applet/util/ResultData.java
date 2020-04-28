package com.three.applet.util;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public  class ResultData {
	
	public static String build(String code, String msg) {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("code",code);
		resultMap.put("msg",msg);
		return JSON.toJSONString(resultMap);
	}


	public static String build(String code, String msg, Map<String, Object> dataMap) {
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("code",code);
		resultMap.put("msg",msg);
		resultMap.put("data",dataMap);
		return JSON.toJSONString(resultMap);
	}
}
