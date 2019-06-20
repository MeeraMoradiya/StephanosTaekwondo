package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;

public interface Student_Parent_Dao {
	
	public long save(Student_Parent sp);

	
	public Student_Parent get(long id);

	
	public List<Student_Parent> list() ;

	
	public void update(long id, Student_Parent sp) ;

	
	public void delete(long id) ;
	
	public Student getStudentByParent(Parent p);
	public Parent getParentByStudent(Student s);

}
