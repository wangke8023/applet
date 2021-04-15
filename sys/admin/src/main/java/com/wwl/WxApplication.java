package com.wwl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author wk
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class WxApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(WxApplication.class, args);
        System.out.println("wwl微信管理系统启动成功");
    }
}
