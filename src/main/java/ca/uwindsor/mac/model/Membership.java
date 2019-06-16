package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="MEMBERSHIP")
public class Membership {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MEMBERSHIP_ID")
	private long membership_id;
	
	@Column(name="START_DATE")
	private Date m_startDate;
	
	@Column(name="END_DATE")
	private Date m_endDate;
	
	@Column(name="COST")
	private double m_cost;
	
	@OneToOne
	private Student student;

	public long getMembership_id() {
		return membership_id;
	}

	public void setMembership_id(long membership_id) {
		this.membership_id = membership_id;
	}

	public Date getM_startDate() {
		return m_startDate;
	}

	public void setM_startDate(Date m_startDate) {
		this.m_startDate = m_startDate;
	}

	public Date getM_endDate() {
		return m_endDate;
	}

	public void setM_endDate(Date m_endDate) {
		this.m_endDate = m_endDate;
	}

	public double getM_cost() {
		return m_cost;
	}

	public void setM_cost(double m_cost) {
		this.m_cost = m_cost;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Membership [membership_id=" + membership_id + ", m_startDate=" + m_startDate + ", m_endDate="
				+ m_endDate + ", m_cost=" + m_cost + ", student=" + student.toString() + "]";
	}
	
	

}
