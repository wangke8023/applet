package com.three.applet.controller.user;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.three.applet.commons.annotation.WebLogger;
import com.three.applet.commons.enums.ResultInfoEnum;
import com.three.applet.util.HttpClientUtil;
import com.three.applet.util.ResultData;
import com.three.applet.util.WechatGetUserInfoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
@RestController
public class UserInfoController {
	@Value("${applet.appid}")
	private String appid;
	@Value("${applet.secret}")
	private String appSecret;
	@RequestMapping("/getUserInfo")
	@WebLogger
	public String getUserInfo(String encryptedData, String iv,String code){
		if(!StringUtils.isNotBlank(code)){
			return ResultData.build(ResultInfoEnum.ILLEGAL_PARAMETER.getCode(),ResultInfoEnum.ILLEGAL_PARAMETER.getMsg()+"code");
		}
		String apiUrl="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+appSecret+"&js_code="+code+"&grant_type=authorization_code";
		System.out.println(apiUrl);
		String responseBody = HttpClientUtil.doGet(apiUrl);
		System.out.println(responseBody);
		JSONObject jsonObject = JSON.parseObject(responseBody);
		if(StringUtils.isNotBlank(jsonObject.getString("openid"))&&StringUtils.isNotBlank(jsonObject.getString("session_key"))){
			//解密获取用户信息
			JSONObject userInfoJSON= WechatGetUserInfoUtil.getUserInfo(encryptedData,jsonObject.getString("session_key"),iv);
			if(userInfoJSON!=null){
				//这步应该set进实体类
				Map userInfo = new HashMap();
				userInfo.put("openId", userInfoJSON.get("openId"));
				userInfo.put("nickName", userInfoJSON.get("nickName"));
				userInfo.put("gender", userInfoJSON.get("gender"));
				userInfo.put("city", userInfoJSON.get("city"));
				userInfo.put("province", userInfoJSON.get("province"));
				userInfo.put("country", userInfoJSON.get("country"));
				userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
				// 解密unionId & openId;
				if (userInfoJSON.get("unionId")!=null) {
					userInfo.put("unionId", userInfoJSON.get("unionId"));
				}
				//然后根据openid去数据库判断有没有该用户信息，若没有则存入数据库，有则返回用户数据
				Map<String,Object> dataMap = new HashMap<>();
				dataMap.put("userInfo", userInfo);
				String uuid= UUID.randomUUID().toString();
				dataMap.put("WXTOKEN", uuid);
				return ResultData.build(ResultInfoEnum.SUCCESS.getCode(),ResultInfoEnum.SUCCESS.getMsg(),dataMap);
			}else{
				return ResultData.build(ResultInfoEnum.FAIL.getCode(),ResultInfoEnum.FAIL.getMsg());
			}
		}else{
			return ResultData.build(ResultInfoEnum.FAIL.getCode(),ResultInfoEnum.FAIL.getMsg());
		}
	}
}
