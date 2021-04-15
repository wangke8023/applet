/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wwl.mall.entity.GoodsSpu;

/**
 * spu商品
 *
 * @author wk
 * @date 2019-08-12 16:25:10
 */
public interface GoodsSpuService extends IService<GoodsSpu> {

	IPage<GoodsSpu> page1(IPage<GoodsSpu> page, GoodsSpu goodsSpu);

	boolean save1(GoodsSpu goodsSpu);

	boolean updateById1(GoodsSpu goodsSpu);

	GoodsSpu getById1(String id);

	GoodsSpu getById2(String id);

}
