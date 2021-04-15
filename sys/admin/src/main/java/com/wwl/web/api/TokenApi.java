/*
  Copyright (C) 2021-2099
  All rights reserved, Designed By www.wwl.com
 */
package com.wwl.web.api;

import com.wwl.common.core.domain.AjaxResult;
import com.wwl.common.core.domain.entity.SysUser;
import com.wwl.common.core.domain.model.LoginUser;
import com.wwl.framework.web.service.TokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信用户
 * @author wk
 * @date 2019-08-25 15:39:39
 */
@Slf4j
@RestController
@RequestMapping("/weixin/api/admin")
@Api(value = "TokenApi", tags = "获取token")
public class TokenApi {
	
	private final TokenService tokenService;

	public TokenApi(TokenService tokenService) {
		this.tokenService = tokenService;
	}

	/**
	 * 获取当前用户token
	 */
	@ApiOperation(value = "获取当前用户token")
	@GetMapping("/getToken")
	public AjaxResult getToken(HttpServletRequest request){
		try {
			String requestURI = request.getRequestURI();
			StringBuffer requestURL = request.getRequestURL();
			System.out.println(requestURI);
			System.out.println(requestURL);
			LoginUser user = new LoginUser();
			SysUser sysUser = new SysUser();
			sysUser.setUserName("admin");
			user.setUser(sysUser);
			String token = tokenService.createToken(user);
			return AjaxResult.success(token);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error(e.getMessage());
		}
	}

	
}
