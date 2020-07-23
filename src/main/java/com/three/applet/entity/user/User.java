package com.three.applet.entity.user;

import com.three.applet.entity.common.BaseEntity;

import javax.validation.constraints.NotBlank;

public class User extends BaseEntity {
	private static final long serialVersionUID = -7430997835973184827L;
	@NotBlank(message="用户名不能为空")
	private String password;
	private String phoneNo;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
