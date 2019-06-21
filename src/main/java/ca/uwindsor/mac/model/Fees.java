package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="FEES")
public class Fees {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="F_ID")
	private long f_id;
	
	@Column(name="F_AMOUNT")
	private double f_amount;
	
	@Column(name="F_DATE")
	private Date f_date;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Membership membership;
	

	public long getF_id() {
		return f_id;
	}

	public void setF_id(long f_id) {
		this.f_id = f_id;
	}

	

	public double getF_amount() {
		return f_amount;
	}

	public void setF_amount(double f_amount) {
		this.f_amount = f_amount;
	}

	public Date getF_date() {
		return f_date;
	}

	public void setF_date(Date f_date) {
		this.f_date = f_date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	@Override
	public String toString() {
		return "Fees [f_id=" + f_id +", f_amount=" + f_amount + ", f_date=" + f_date
				+ ", student=" + student.toString() + ", membership=" + membership.toString() + "]";
	}

	
	
	
}
