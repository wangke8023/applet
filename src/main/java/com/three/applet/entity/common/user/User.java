package com.three.applet.entity.common.user;

import com.three.applet.entity.common.BaseEntity;

public class User extends BaseEntity {
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
