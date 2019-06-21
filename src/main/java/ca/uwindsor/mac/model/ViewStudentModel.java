package ca.uwindsor.mac.model;

import java.util.Date;

public class ViewStudentModel {
	
	private Student student;
	private Membership mem;
	private Fees fees;
	private Parent parent;
	private Student_Parent sp;
	private Rank rank;
	private Rank_Student rs;
	private Class cls;
	private int attend;
	private Date rankDate;
	
	
	
	Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Membership getMem() {
		return mem;
	}
	public void setMem(Membership mem) {
		this.mem = mem;
	}
	public Fees getFees() {
		return fees;
	}
	public void setFees(Fees fees) {
		this.fees = fees;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Student_Parent getSp() {
		return sp;
	}
	public void setSp(Student_Parent sp) {
		this.sp = sp;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public Rank_Student getRs() {
		return rs;
	}
	public void setRs(Rank_Student rs) {
		this.rs = rs;
	}
	public Class getCls() {
		return cls;
	}
	public void setCls(Class cls) {
		this.cls = cls;
	}
	public int getAttend() {
		return attend;
	}
	public void setAttend(int attend) {
		this.attend = attend;
	}
	
	
	public Date getRankDate() {
		return rankDate;
	}
	public void setRankDate(Date rankDate) {
		this.rankDate = rankDate;
	}
	@Override
	public String toString() {
		return "ViewStudentModel [student=" + student + ", mem=" + mem + ", fees=" + fees + ", parent=" + parent
				+ ", sp=" + sp + ", rank=" + rank + ", rs=" + rs + ", cls=" + cls + ", attend=" + attend + ", rankDate="
				+ rankDate + "]";
	}
	
	
	
	
	
	

}
