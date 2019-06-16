package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Parent;
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


}
