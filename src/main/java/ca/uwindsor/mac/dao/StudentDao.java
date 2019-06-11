package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Student;


public interface StudentDao {
	 long save(Student student);

	 Student get(long id);

	   List<Student> list();

	   void update(long id, Student student);

	   void delete(long id);
}
