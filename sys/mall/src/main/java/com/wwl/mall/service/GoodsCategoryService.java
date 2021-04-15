/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 */
package com.wwl.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wwl.mall.entity.GoodsCategory;
import com.wwl.mall.entity.GoodsCategoryTree;

import java.util.List;

/**
 * 商品类目
 *
 * @author wk
 * @date 2019-08-12 11:46:28
 */
public interface GoodsCategoryService extends IService<GoodsCategory> {

	/**
	 * 查询类目树
	 *
	 * @return 树
	 */
	List<GoodsCategoryTree> selectTree(GoodsCategory goodsCategory);
}
