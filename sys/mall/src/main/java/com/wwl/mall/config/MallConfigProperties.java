/**
 * Copyright (C) 2018-2019
 * All rights reserved, Designed By www.wwl.com
 * 注意：
 * 本软件为www.wwl.com开发研制，项目使用请保留此说明
 */
package com.wwl.mall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 商城相关配置
 *
 * @author
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mall")
public class MallConfigProperties {

	private String notifyHost = "notify-host";

	private String logisticsKey = "logistics-key";
}
