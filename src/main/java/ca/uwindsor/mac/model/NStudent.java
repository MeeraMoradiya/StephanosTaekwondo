package ca.uwindsor.mac.model;

public class NStudent {
	
	private Student student;
	private Parent parent;
	private Rank rank;
	private String relation;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Parent getParent() {
		return parent;
	}
	public void setParent(Parent parent) {
		this.parent = parent;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	@Override
	public String toString() {
		return "NStudent [student=" + student + ", parent=" + parent + ", rank=" + rank + ", relation=" + relation
				+ "]";
	}
	

}
