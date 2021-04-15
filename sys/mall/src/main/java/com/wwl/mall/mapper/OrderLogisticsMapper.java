/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wwl.mall.entity.OrderLogistics;

import java.io.Serializable;

/**
 * 订单物流
 *
 * @author wk
 * @date 2019-09-16 09:53:17
 */
public interface OrderLogisticsMapper extends BaseMapper<OrderLogistics> {

	OrderLogistics selectById2(Serializable id);
}
