package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="ATTANDENCE")
public class Attendance {

	@Id
	@Column(name="A_DATETIME")
	private Date A_dateTime;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Class cls;

	public Date getA_dateTime() {
		return A_dateTime;
	}

	public void setA_dateTime(Date a_dateTime) {
		A_dateTime = a_dateTime;
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
		return "Attendance [A_dateTime=" + A_dateTime + ", student=" + student.toString() + ", cls=" + cls.toString() + "]";
	}
	
	
}
