/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwl.mall.entity.OrderLogistics;
import com.wwl.mall.mapper.OrderLogisticsMapper;
import com.wwl.mall.service.OrderLogisticsService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * 订单物流
 *
 * @author wk
 * @date 2019-09-16 09:53:17
 */
@Service
public class OrderLogisticsServiceImpl extends ServiceImpl<OrderLogisticsMapper, OrderLogistics> implements OrderLogisticsService {

	@Override
	public OrderLogistics getById(Serializable id) {
		return baseMapper.selectById2(id);
	}
}
