package ca.uwindsor.mac.model;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="T_CLASS")
public class Class {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CLASS_ID")
	private long class_id;
	
	@Column(name="CLASS_DATE")
	private Date class_date;
	
	@Column(name="START_TIME")
	private String startTime;
	
	@Column(name="END_TIME")
	private String endTime;
	
	@Column(name="LEVEL")
	private String level;

	public long getClass_id() {
		return class_id;
	}

	public void setClass_id(long class_id) {
		this.class_id = class_id;
	}

	public Date getClass_date() {
		return class_date;
	}

	public void setClass_date(Date class_date) {
		this.class_date = class_date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Class [class_id=" + class_id + ", class_date=" + class_date + ", startTime=" + startTime + ", endTime="
				+ endTime + ", level=" + level + "]";
	}


}
