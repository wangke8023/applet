package com.three.applet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//      http.httpBasic()// httpBasic 登录
		http.formLogin()// 表单登录  来身份认证
				.loginPage("/html/myLogin.html")// 自定义登录页面
				.loginProcessingUrl("/authentication/form")// 自定义登录路径
				.and()
				.authorizeRequests()// 对请求授权
				// error  127.0.0.1 将您重定向的次数过多
				.antMatchers("/html/myLogin.html", "/authentication/require",
						"/authentication/form").permitAll()// 这些页面不需要身份认证,其他请求需要认证
				.anyRequest() // 任何请求
				.authenticated()//; // 都需要身份认证
				.and()
				.csrf().disable();// 禁用跨站攻击
	}

}
