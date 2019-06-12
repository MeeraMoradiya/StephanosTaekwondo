package ca.uwindsor.mac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="PARENT")
public class Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PARENT_ID")
	private long parent_id;
	
	@Column(name="PARENT_NAME")
	private String parent_name;
	
	@Column(name="PARENT_PHONE")
	private String parent_phone;
	
	@Column(name="PARENT_EMAIL")
	private String parent_email;

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
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

	public String getParent_email() {
		return parent_email;
	}

	public void setParent_email(String parent_email) {
		this.parent_email = parent_email;
	}

	@Override
	public String toString() {
		return "Parent [parent_id=" + parent_id + ", parent_name=" + parent_name + ", parent_phone=" + parent_phone
				+ ", parent_email=" + parent_email + "]";
	}

}
