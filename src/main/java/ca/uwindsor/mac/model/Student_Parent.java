package ca.uwindsor.mac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity(name="STUDENT_PARENT")
public class Student_Parent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="SP_ID")
	private long sp_id;

	@Column(name="SP_RELATION")
	private String sp_relation;
	
	@OneToOne
	private Student student;
	
	@OneToOne
	private Parent parent;

	public long getSp_id() {
		return sp_id;
	}

	public void setSp_id(long sp_id) {
		this.sp_id = sp_id;
	}

	public String getSp_relation() {
		return sp_relation;
	}

	public void setSp_relation(String sp_relation) {
		this.sp_relation = sp_relation;
	}

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

	@Override
	public String toString() {
		return "Student_Parent [sp_id=" + sp_id + ", sp_relation=" + sp_relation + ", student=" + student.toString() + ", parent="
				+ parent.toString() + "]";
	}
	
	
}
