package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;
	private String student_fname;
	private String student_lname;
	private Date student_dob;
	private Date student_joinDate;
	private long student_phone;
	private String student_email;
	private String student_address;
	private String student_city;
	private String student_state;
	private String student_postal_code;
	private String student_status;
	private long patent_id;

	public long getPatent_id() {
		return patent_id;
	}

	public void setPatent_id(long patent_id) {
		this.patent_id = patent_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public void setStudent_phone(long student_phone) {
		this.student_phone = student_phone;
	}

	public Long getStudent_id() {
		return student_id;

	}

	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_fname() {
		return student_fname;
	}

	public void setStudent_fname(String student_fname) {
		this.student_fname = student_fname;
	}

	public String getStudent_lname() {
		return student_lname;
	}

	public void setStudent_lname(String student_lname) {
		this.student_lname = student_lname;
	}

	public Date getStudent_dob() {
		return student_dob;
	}

	public void setStudent_dob(Date student_dob) {
		this.student_dob = student_dob;
	}

	public Date getStudent_joinDate() {
		return student_joinDate;
	}

	public void setStudent_joinDate(Date student_joinDate) {
		this.student_joinDate = student_joinDate;
	}

	public Long getStudent_phone() {
		return student_phone;
	}

	public void setStudent_phone(Long student_phone) {
		this.student_phone = student_phone;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_address() {
		return student_address;
	}

	public void setStudent_address(String student_address) {
		this.student_address = student_address;
	}

	public String getStudent_city() {
		return student_city;
	}

	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}

	public String getStudent_state() {
		return student_state;
	}

	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}

	public String getStudent_postal_code() {
		return student_postal_code;
	}

	public void setStudent_postal_code(String student_postal_code) {
		this.student_postal_code = student_postal_code;
	}

	public String getStudent_status() {
		return student_status;
	}

	public void setStudent_status(String student_status) {
		this.student_status = student_status;
	}
	
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", student_fname=" + student_fname + ", student_lname="
				+ student_lname + ", student_dob=" + student_dob + ", student_joinDate=" + student_joinDate
				+ ", student_phone=" + student_phone + ", student_email=" + student_email + ", student_address="
				+ student_address + ", student_city=" + student_city + ", student_state=" + student_state
				+ ", student_postal_code=" + student_postal_code + ", student_status=" + student_status + ", patent_id="
				+ patent_id + "]";
	}

}
