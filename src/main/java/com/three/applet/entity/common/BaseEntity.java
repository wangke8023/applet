package com.three.applet.entity.common;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity implements Serializable {
	protected String Id;
	protected Date createdDate;
	protected Date updateDate;
	

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
