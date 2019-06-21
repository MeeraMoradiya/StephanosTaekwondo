package ca.uwindsor.mac.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.uwindsor.mac.model.Student;


public interface StudentDao {
	 long save(Student student);

	 Student get(long id);

	   List<Student> list();

	   void update(long id, Student student);

	   void delete(long id);
	   
	   public ArrayList<Long> getStudentListByDOJ(java.sql.Date fromDate,java.sql.Date toDate);
	   public ArrayList<Long> getStudentListByCity(String city);
	   public ArrayList<Long> getStudentListByStatus(String status);
	   public List<Student> getStudentByName(String name); 
}
