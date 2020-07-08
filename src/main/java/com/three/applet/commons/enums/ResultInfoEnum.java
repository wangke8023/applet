package com.three.applet.commons.enums;

public enum ResultInfoEnum {
	//请求处理失败
	FAIL("999","失败"),
	//请求处理成功
	SUCCESS("000","成功"),
	NULL_PARAMETER("901","参数格式不正确"),
	ILLEGAL_PARAMETER("902","必填参数为空:"),
	NOT_LOGIN("904","未登录");
	ResultInfoEnum(String code,String msg){
		this.code = code;
		this.msg =msg;
	}
	private String code;
	private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
