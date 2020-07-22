package com.three.applet.controller;


import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionAdvice {
	/**
	 * 日志
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public String defaultExceptionHandler(Exception exception) {
		try {
			throw exception;
		} catch (MethodArgumentNotValidException argEx) {
			FieldError fieldError = argEx.getBindingResult().getFieldError();
			String errorMsg = String.format("%s >> %s", fieldError.getField(),
					fieldError.getDefaultMessage());
			LOGGER.error("【全局异常捕获】>> 参数校验异常  >>  {}", errorMsg);
		} catch (HttpRequestMethodNotSupportedException e) {
			String errorMsg = String.format("请求方式 %s 错误 ! 请使用 %s 方式", e.getMethod(), e.getSupportedHttpMethods());
			LOGGER.error("【全局异常捕获】>> {}", errorMsg);
		} catch (HttpMediaTypeNotSupportedException e) {
			String errorMsg = String.format("请求类型 %s 错误 ! 请使用 %s 方式", e.getContentType(), e.getSupportedMediaTypes());
			LOGGER.error("【全局异常捕获】>> {}", errorMsg);
		} catch (Exception e) {
			LOGGER.error("【全局异常捕获】>>  未知异常 stack = {}", ExceptionUtils.getStackTrace(e));
		}
		return "";
	}
}
