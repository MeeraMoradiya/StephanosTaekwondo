package ca.uwindsor.mac.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import ca.uwindsor.mac.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	 @Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public long save(Student student) {
		sessionFactory.getCurrentSession().save(student);
	      return student.getStudent_id();
	}

	@Override
	public Student get(long id) {
		 return sessionFactory.getCurrentSession().get(Student.class, id);
	 }

	@Override
	public  List<Student> list(){
		   List<Student> list = sessionFactory.getCurrentSession().createQuery("from STUDENT").list();
		      return list;
	   }
	@Override
	public   void update(long id, Student student) {
		   Session session = sessionFactory.getCurrentSession();
		      Student student2 = session.byId(Student.class).load(id);
		  
		      student2.setStudent_fname(student.getStudent_fname());
		      student2.setStudent_lname(student.getStudent_fname());
		      student2.setStudent_nickname(student.getStudent_nickname());
		      student2.setStudent_dob(student.getStudent_dob());
		      student2.setStudent_joinDate(student.getStudent_joinDate());
		      student2.setStudent_phone(student.getStudent_phone());
		      student2.setStudent_email(student.getStudent_email());
		      student2.setStudent_address(student.getStudent_address());
		      student2.setStudent_city(student.getStudent_city());
		      student2.setStudent_state(student.getStudent_state());
		      student2.setStudent_postal_code(student.getStudent_postal_code());
		      student2.setStudent_status(student.getStudent_status());
		    
		      session.flush();
	   }
	@Override
	public   void delete(long id) {
		   Student student = sessionFactory.getCurrentSession().byId(Student.class).load(id);
		      sessionFactory.getCurrentSession().delete(student);
	   }

	
	public ArrayList<Long> getStudentListByDOJ(java.sql.Date fromDate,java.sql.Date toDate) {
		ArrayList<Long> lst =new ArrayList<Long>(); 
		 try {
		   
	     System.out.println("Start Date is: "+fromDate);  
		
		 
	    
	     System.out.println("End Date is: "+toDate);  
		 
		List<Student> list = sessionFactory.getCurrentSession().createQuery("from STUDENT WHERE STUDENT_JOINDATE >= TO_DATE("+fromDate+", 'YYYY-MM-DD') AND STUDENT_JOINDATE <= "+toDate).list();
		for(Student st : list) {
			lst.add(st.getStudent_id());
		}
		 }catch(Exception e) {
			 System.out.println("Exception Occured"+e);
		 }
		return lst;
	}
	
	public ArrayList<Long> getStudentListByCity(String city){
		ArrayList<Long> lst =new ArrayList<Long>(); 
		List<Student> list = sessionFactory.getCurrentSession().createQuery("from STUDENT WHERE STUDENT_CITY='"+city+"'").list();
		for(Student st : list) {
			lst.add(st.getStudent_id());
		}
		return lst;
	}
	
	public ArrayList<Long> getStudentListByStatus(String status){
		ArrayList<Long> lst =new ArrayList<Long>(); 
		List<Student> list = sessionFactory.getCurrentSession().createQuery("from STUDENT WHERE STUDENT_STATUS='"+status+"'").list();
		for(Student st : list) {
			lst.add(st.getStudent_id());
		}
		return lst;
	}
}
