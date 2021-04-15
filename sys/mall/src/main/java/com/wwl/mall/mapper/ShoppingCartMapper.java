/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wwl.mall.entity.ShoppingCart;
import org.apache.ibatis.annotations.Param;

/**
 * 购物车
 *
 * @author wk
 * @date 2019-08-29 21:27:33
 */
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

	IPage<ShoppingCart> selectPage2(IPage<ShoppingCart> page, @Param("query") ShoppingCart shoppingCart);
}
