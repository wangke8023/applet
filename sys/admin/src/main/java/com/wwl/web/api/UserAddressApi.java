/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.web.api;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wwl.common.core.domain.AjaxResult;
import com.wwl.mall.entity.UserAddress;
import com.wwl.mall.service.UserAddressService;
import com.wwl.weixin.utils.ThirdSessionHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 用户收货地址
 *
 * @author wk
 * @date 2019-09-11 14:28:59
 */
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/weixin/api/ma/useraddress")
@Api(value = "useraddress", tags = "用户收货地址API")
public class UserAddressApi {

    private final UserAddressService userAddressService;

    /**
    * 分页查询
    * @param page 分页对象
    * @param userAddress 用户收货地址
    * @return
    */
	@ApiOperation(value = "分页查询")
    @GetMapping("/page")
    public AjaxResult getUserAddressPage(Page page, UserAddress userAddress) {
		userAddress.setUserId(ThirdSessionHolder.getWxUserId());
        return AjaxResult.success(userAddressService.page(page,Wrappers.query(userAddress)));
    }

    /**
    * 新增、修改用户收货地址
    * @param userAddress 用户收货地址
    * @return AjaxResult
    */
	@ApiOperation(value = "新增、修改用户收货地址")
    @PostMapping
    public AjaxResult save(@RequestBody UserAddress userAddress){
		userAddress.setUserId(ThirdSessionHolder.getWxUserId());
        return AjaxResult.success(userAddressService.saveOrUpdate(userAddress));
    }

    /**
    * 通过id删除用户收货地址
    * @param id
    * @return AjaxResult
    */
	@ApiOperation(value = "通过id删除用户收货地址")
    @DeleteMapping("/{id}")
    public AjaxResult removeById(@PathVariable String id){
		return AjaxResult.success(userAddressService.removeById(id));
    }

}
