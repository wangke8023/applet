/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wwl.mall.entity.ShoppingCart;

/**
 * 购物车
 *
 * @author wk
 * @date 2019-08-29 21:27:33
 */
public interface ShoppingCartService extends IService<ShoppingCart> {

	IPage<ShoppingCart> page2(IPage<ShoppingCart> page, ShoppingCart shoppingCart);
}
