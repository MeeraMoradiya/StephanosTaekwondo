package ca.uwindsor.mac.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="RANK_STUDENT")
public class Rank_Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RS_ID")
	private long RS_id;
	
	@OneToOne
	private Rank rank;
	
	@OneToOne
	private Student student;
	
	@Column(name="RANK_DATE")
	private Date rank_date;

	public long getRS_id() {
		return RS_id;
	}

	public void setRS_id(long rS_id) {
		RS_id = rS_id;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Date getRank_date() {
		return rank_date;
	}

	public void setRank_date(Date rank_date) {
		this.rank_date = rank_date;
	}

	@Override
	public String toString() {
		return "Rank_Student [RS_id=" + RS_id + ", rank=" + rank.toString() + ", student=" + student.toString() + ", rank_date=" + rank_date
				+ "]";
	}
	
	
}
