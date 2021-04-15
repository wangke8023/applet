/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.entity;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.wwl.mall.enums.OrderLogisticsEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 订单物流
 *
 * @author wk
 * @date 2019-09-16 09:53:17
 */
@Data
@TableName("order_logistics")
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "订单物流")
public class OrderLogistics extends Model<OrderLogistics> {
  private static final long serialVersionUID = 1L;

    /**
   * PK
   */
	@ApiModelProperty(value = "PK")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
   * 逻辑删除标记（0：显示；1：隐藏）
   */
	@ApiModelProperty(value = "逻辑删除标记")
    private String delFlag;
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
   * 邮编
   */
	@ApiModelProperty(value = "邮编")
    private String postalCode;
    /**
   * 收货人名字
   */
	@ApiModelProperty(value = "收货人名字")
    private String userName;
    /**
   * 电话号码
   */
	@ApiModelProperty(value = "电话号码")
    private String telNum;
    /**
   * 详细地址
   */
	@ApiModelProperty(value = "详细地址")
    private String address;
    /**
   * 物流商家
   */
	@ApiModelProperty(value = "物流商家")
    private String logistics;
	/**
	 * 物流商家
	 */
	@TableField(exist = false)
	private String logisticsDesc;
	public String getLogisticsDesc() {
		if(this.logistics == null){
			return null;
		}
		return OrderLogisticsEnum.valueOf(OrderLogisticsEnum.LOGISTICS_PREFIX + "_" + StrUtil.swapCase(this.logistics)).getDesc();
	}
    /**
   * 物流单号
   */
    private String logisticsNo;
	/**
	 * 快递单当前状态，包括-1错误，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转投 等7个状态
	 */
	private String status;
	/**
	 * 快递单当前状态，包括-1错误，0在途，1揽收，2疑难，3签收，4退签，5派件，6退回，7转投 等7个状态
	 */
	@TableField(exist = false)
	private String statusDesc;
	public String getStatusDesc() {
		if(this.status == null){
			return null;
		}
		return OrderLogisticsEnum.valueOf(OrderLogisticsEnum.STATUS_PREFIX + "_" + this.status).getDesc();
	}
	/**
	 * 是否签收标记（0：是；1：否）
	 */
	private String isCheck;
	/**
	 * 错误信息
	 */
	private String message;
	/**
	 * 物流详情
	 */
//	@TableField(exist = false)
//	private List<OrderLogisticsDetail> listOrderLogisticsDetail;
}
