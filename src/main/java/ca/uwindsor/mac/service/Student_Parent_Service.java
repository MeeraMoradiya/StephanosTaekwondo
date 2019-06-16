package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Student_Parent;



public interface Student_Parent_Service {

	long save(Student_Parent sp);
	Student_Parent get(long id);
	   List<Student_Parent> list();
	   void update(long id, Student_Parent sp);
	   void delete(long id);
}
