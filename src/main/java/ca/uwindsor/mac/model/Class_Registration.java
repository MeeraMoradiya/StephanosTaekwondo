package ca.uwindsor.mac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="CLASS_REGISTRATION")
public class Class_Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CR_ID")
	private long cr_id;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Class cls;

	public long getCr_id() {
		return cr_id;
	}

	public void setCr_id(long cr_id) {
		this.cr_id = cr_id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Class getCls() {
		return cls;
	}

	public void setCls(Class cls) {
		this.cls = cls;
	}

	@Override
	public String toString() {
		return "Class_Registration [cr_id=" + cr_id + ", student=" + student.toString() + ", cls=" + cls.toString() + "]";
	}

	
	
}
