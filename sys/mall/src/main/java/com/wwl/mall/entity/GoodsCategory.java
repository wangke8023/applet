/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 */
package com.wwl.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 商品类目
 *
 * @author wk
 * @date 2019-08-12 11:46:28
 */
@Data
@TableName("goods_category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "商品类目")
public class GoodsCategory extends Model<GoodsCategory> {
private static final long serialVersionUID = 1L;

    /**
   * PK
   */
	@ApiModelProperty(value = "PK")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
	/**
	 * （1：开启；0：关闭）
	 */
	@ApiModelProperty(value = "1：开启；0：关闭")
	private String enable;
    /**
   * 父分类编号
   */
	@ApiModelProperty(value = "父分类编号")
    private String parentId;
    /**
   * 名称
   */
	@ApiModelProperty(value = "名称")
    private String name;
    /**
   * 描述
   */
	@ApiModelProperty(value = "描述")
    private String description;
    /**
   * 图片
   */
	@ApiModelProperty(value = "图片")
    private String picUrl;
    /**
   * 排序
   */
	@ApiModelProperty(value = "排序")
    private Integer sort;
    /**
   * 创建时间
   */
	@ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;
    /**
   * 最后更新时间
   */
	@ApiModelProperty(value = "最后更新时间")
    private LocalDateTime updateTime;
    /**
   * 逻辑删除标记（0：显示；1：隐藏）
   */
	@ApiModelProperty(value = "逻辑删除标记")
    private String delFlag;
  
}
