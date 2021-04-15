/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wwl.mall.entity.GoodsSpu;
import com.wwl.mall.mapper.GoodsSpuMapper;
import com.wwl.mall.service.GoodsSpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * spu商品
 *
 * @author wk
 * @date 2019-08-12 16:25:10
 */
@Service
public class GoodsSpuServiceImpl extends ServiceImpl<GoodsSpuMapper, GoodsSpu> implements GoodsSpuService {


	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean removeById(Serializable id) {
		super.removeById(id);
		return true;
	}

	@Override
	public IPage<GoodsSpu> page1(IPage<GoodsSpu> page, GoodsSpu goodsSpu) {
		return baseMapper.selectPage1(page, goodsSpu);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean save1(GoodsSpu goodsSpu) {
		baseMapper.insert(goodsSpu);
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean updateById1(GoodsSpu goodsSpu) {
		baseMapper.updateById(goodsSpu);
		return true;
	}

	@Override
	public GoodsSpu getById1(String id) {
		return baseMapper.selectById1(id);
	}

	@Override
	public GoodsSpu getById2(String id) {
		return baseMapper.selectById2(id);
	}

}
