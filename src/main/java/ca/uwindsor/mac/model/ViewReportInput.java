package ca.uwindsor.mac.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ViewReportInput {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date reportFrom;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date reportTo;
	private String belt;
	private String city;
	private String classLevel;
	private String status;
	
	
	public Date getReportFrom() {
		return reportFrom;
	}
	public void setReportFrom(Date reportFrom) {
		this.reportFrom = reportFrom;
	}
	public Date getReportTo() {
		return reportTo;
	}
	public void setReportTo(Date reportTo) {
		this.reportTo = reportTo;
	}
	public String getBelt() {
		return belt;
	}
	public void setBelt(String belt) {
		this.belt = belt;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(String classLevel) {
		this.classLevel = classLevel;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ViewReportInput [reportFrom=" + reportFrom + ", reportTo=" + reportTo + ", belt=" + belt + ", city="
				+ city + ", classLevel=" + classLevel + ", status=" + status + "]";
	}
	
	

}
