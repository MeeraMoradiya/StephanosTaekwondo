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
	
	
	@Column(name="M_DURATION")
	private String m_duration;
	
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

	

	public String getM_duration() {
		return m_duration;
	}

	public void setM_duration(String m_duration) {
		this.m_duration = m_duration;
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
		return "Membership [membership_id=" + membership_id + ", m_duration=" + m_duration + ", m_cost=" + m_cost
				+ ", student=" + student + "]";
	}

	
	

}
