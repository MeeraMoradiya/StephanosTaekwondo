package ca.uwindsor.mac.model;

import java.util.Date;

public class NewStudent {
	private String student_fname;
	private String student_lname;
	private String student_city;
	private Date dob;
	private String student_email;
	private String student_level;
	private String student_nickname;
	private long student_phone;
	private String student_postal_code;
	private String student_rank;
	private String student_state;
	private String parent_email;
	private String parent_name;
	private String parent_phone;
	private String parent_relation;
	private String student_address;
	public String getStudent_address() {
		return student_address;
	}
	public void setStudent_address(String student_address) {
		this.student_address = student_address;
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
	public String getStudent_city() {
		return student_city;
	}
	public void setStudent_city(String student_city) {
		this.student_city = student_city;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getStudent_email() {
		return student_email;
	}
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	public String getStudent_level() {
		return student_level;
	}
	public void setStudent_level(String student_level) {
		this.student_level = student_level;
	}
	public String getStudent_nickname() {
		return student_nickname;
	}
	public void setStudent_nickname(String student_nickname) {
		this.student_nickname = student_nickname;
	}
	public long getStudent_phone() {
		return student_phone;
	}
	public void setStudent_phone(long student_phone) {
		this.student_phone = student_phone;
	}
	public String getStudent_postal_code() {
		return student_postal_code;
	}
	public void setStudent_postal_code(String student_postal_code) {
		this.student_postal_code = student_postal_code;
	}
	public String getStudent_rank() {
		return student_rank;
	}
	public void setStudent_rank(String student_rank) {
		this.student_rank = student_rank;
	}
	public String getStudent_state() {
		return student_state;
	}
	public void setStudent_state(String student_state) {
		this.student_state = student_state;
	}
	public String getParent_email() {
		return parent_email;
	}
	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}
	public String getParent_phone() {
		return parent_phone;
	}
	public void setParent_phone(String parent_phone) {
		this.parent_phone = parent_phone;
	}
	public String getParent_relation() {
		return parent_relation;
	}
	public void setParent_relation(String parent_relation) {
		this.parent_relation = parent_relation;
	}
	@Override
	public String toString() {
		return "NewStudent [student_fname=" + student_fname + ", student_lname=" + student_lname + ", student_city="
				+ student_city + ", dob=" + dob + ", student_email=" + student_email + ", student_level="
				+ student_level + ", student_nickname=" + student_nickname + ", student_phone=" + student_phone
				+ ", student_postal_code=" + student_postal_code + ", student_rank=" + student_rank + ", student_state="
				+ student_state + ", parent_email=" + parent_email + ", parent_name=" + parent_name + ", parent_phone="
				+ parent_phone + ", parent_relation=" + parent_relation + ", student_address=" + student_address + "]";
	}
	
	
	
	

}
