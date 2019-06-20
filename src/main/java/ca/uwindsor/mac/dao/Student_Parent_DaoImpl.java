package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;

@Repository
public class Student_Parent_DaoImpl implements Student_Parent_Dao{
	
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Student_Parent sp) {
		sessionFactory.getCurrentSession().save(sp);
	      return sp.getSp_id();
	}

	@Override
	public Student_Parent get(long id) {
		return sessionFactory.getCurrentSession().get(Student_Parent.class, id);
	}

	@Override
	public List<Student_Parent> list() {
		List<Student_Parent> list = sessionFactory.getCurrentSession().createQuery("from STUDENT_PARENT").list();
	      return list;
	}

	@Override
	public void update(long id, Student_Parent sp) {
		 Session session = sessionFactory.getCurrentSession();
		 Student_Parent sp2 = session.byId(Student_Parent.class).load(id);
	     sp2.setSp_relation(sp.getSp_relation());
	     sp2.setStudent(sp.getStudent());
	     sp2.setParent(sp.getParent());
	     session.flush();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Student_Parent sp= sessionFactory.getCurrentSession().byId(Student_Parent.class).load(id);
	      sessionFactory.getCurrentSession().delete(sp);
	}

	@Override
	public Student getStudentByParent(Parent p) {
		Student_Parent s=sessionFactory.getCurrentSession().get(Student_Parent.class,p.getParent_id());
		return s.getStudent();
	}

	@Override
	public Parent getParentByStudent(Student s) {
		System.out.println("DAO Student"+s);
		List<Student_Parent> list = sessionFactory.getCurrentSession().createQuery("from STUDENT_PARENT WHERE STUDENT_STUDENT_ID="+s.getStudent_id()).list();
	    //  return list.get(0).getRank();
		return list.get(0).getParent();
	}


}
