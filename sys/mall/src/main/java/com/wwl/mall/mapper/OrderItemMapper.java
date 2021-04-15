/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wwl.mall.entity.OrderItem;

import java.util.List;

/**
 * 商城订单详情
 *
 * @author wk
 * @date 2019-09-10 15:31:40
 */
public interface OrderItemMapper extends BaseMapper<OrderItem> {

	List<OrderItem> selectList2(OrderItem orderItem);

}
