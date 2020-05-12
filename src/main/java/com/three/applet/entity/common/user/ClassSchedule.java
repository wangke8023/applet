package com.three.applet.entity.common.user;

import com.three.applet.entity.common.BaseEntity;

import java.util.Date;

public class ClassSchedule extends BaseEntity {
	private static final long serialVersionUID = -4045550010561672584L;
	private Date classTime;
	private String teacherId;
	private String teacherName;
	
	public Date getClassTime() {
		return classTime;
	}

	public void setClassTime(Date classTime) {
		this.classTime = classTime;
	}
}
