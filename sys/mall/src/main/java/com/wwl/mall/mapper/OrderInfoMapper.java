/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wwl.mall.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * 商城订单
 *
 * @author wk
 * @date 2019-09-10 15:21:22
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

	IPage<OrderInfo> selectPage1(IPage<OrderInfo> page, @Param("query") OrderInfo orderInfo);

	IPage<OrderInfo> selectPage2(IPage<OrderInfo> page, @Param("query") OrderInfo orderInfo);

	OrderInfo selectById2(Serializable id);
}
