package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;



public interface Student_Parent_Service {

	long save(Student_Parent sp);
	Student_Parent get(long id);
	Student getStudentByParent(Parent p);
	Parent getParentByStudent(Student s);
	   List<Student_Parent> list();
	   void update(long id, Student_Parent sp);
	   void delete(long id);
}
