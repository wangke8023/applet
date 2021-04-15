/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwl.mall.config.CommonConstants;
import com.wwl.mall.entity.UserAddress;
import com.wwl.mall.mapper.UserAddressMapper;
import com.wwl.mall.service.UserAddressService;
import org.springframework.stereotype.Service;

/**
 * 用户收货地址
 *
 * @author wk
 * @date 2019-09-11 14:28:59
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<UserAddressMapper, UserAddress> implements UserAddressService {

	@Override
	public boolean save(UserAddress entity) {
		setIsDefault(entity);
		return super.save(entity);
	}

	@Override
	public boolean updateById(UserAddress entity) {
		setIsDefault(entity);
		return super.updateById(entity);
	}

	/**
	 * 修改默认地址
	 * @param entity
	 */
	void setIsDefault(UserAddress entity){
		if(CommonConstants.YES.equals(entity.getIsDefault())){
			UserAddress userAddress = new UserAddress();
			userAddress.setIsDefault(CommonConstants.NO);
			super.update(userAddress, Wrappers.<UserAddress>lambdaQuery()
					.eq(UserAddress::getUserId,entity.getUserId())
					.eq(UserAddress::getIsDefault,CommonConstants.YES));
		}
	}
}
