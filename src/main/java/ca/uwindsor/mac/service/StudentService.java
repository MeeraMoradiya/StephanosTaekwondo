package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Student;


public interface StudentService {
	
	 long save(Student student);
	 Student get(long id);
	   List<Student> list();
	   void update(long id, Student book);
	   void delete(long id);

}
