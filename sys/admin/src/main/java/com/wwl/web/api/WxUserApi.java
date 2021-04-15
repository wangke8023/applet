/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 */
package com.wwl.web.api;

import com.wwl.common.core.domain.AjaxResult;
import com.wwl.weixin.entity.LoginMaDTO;
import com.wwl.weixin.entity.WxOpenDataDTO;
import com.wwl.weixin.entity.WxUser;
import com.wwl.weixin.service.WxUserService;
import com.wwl.weixin.utils.ThirdSessionHolder;
import com.wwl.weixin.utils.WxMaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信用户
 *
 * @author wk
 * @date 2019-08-25 15:39:39
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/weixin/api/ma/wxuser")
@Api(value = "wxuser", tags = "小程序用户API")
public class WxUserApi {

	private final WxUserService wxUserService;
	/**
	 * 小程序用户登录
	 * @param request
	 * @param loginMaDTO
	 * @return
	 */
	@ApiOperation(value = "小程序用户登录")
	@PostMapping("/login")
	public AjaxResult login(HttpServletRequest request, @RequestBody LoginMaDTO loginMaDTO){
		try {
			WxUser wxUser = wxUserService.loginMa(WxMaUtil.getAppId(request),loginMaDTO.getJsCode());
			return AjaxResult.success(wxUser);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error(e.getMessage());
		}
	}

	/**
	 * 获取用户信息
	 * @param
	 * @return
	 */
	@ApiOperation(value = "获取用户信息")
	@GetMapping
	public AjaxResult get(){
		String id = ThirdSessionHolder.getThirdSession().getWxUserId();
		return AjaxResult.success(wxUserService.getById(id));
	}

	/**
	 * 保存用户信息
	 * @param wxOpenDataDTO
	 * @return
	 */
	@ApiOperation(value = "保存用户信息")
	@PostMapping
	public AjaxResult saveOrUptateWxUser(@RequestBody WxOpenDataDTO wxOpenDataDTO){
		wxOpenDataDTO.setAppId(ThirdSessionHolder.getThirdSession().getAppId());
		wxOpenDataDTO.setUserId(ThirdSessionHolder.getThirdSession().getWxUserId());
		wxOpenDataDTO.setSessionKey(ThirdSessionHolder.getThirdSession().getSessionKey());
		WxUser wxUser = wxUserService.saveOrUptateWxUser(wxOpenDataDTO);
		return AjaxResult.success(wxUser);
	}
}
