package com.three.applet.entity.common;

import java.io.Serializable;

public class BaseEntity implements Serializable {
	protected String Id;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}
}
