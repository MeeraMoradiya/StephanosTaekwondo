package ca.uwindsor.mac.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ca.uwindsor.mac.model.Class_Registration;
import ca.uwindsor.mac.model.Student_Parent;

@Repository
public class Class_Registration_DaoImpl implements ClassRegistrationDao{
	
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Class_Registration cls) {
		sessionFactory.getCurrentSession().save(cls);
	      return cls.getCr_id();
	}

	@Override
	public Class_Registration get(long id) {
		return sessionFactory.getCurrentSession().get(Class_Registration.class, id);
	}

	@Override
	public List<Class_Registration> list() {
		List<Class_Registration> list = sessionFactory.getCurrentSession().createQuery("from CLASS_REGISTRATION").list();
	      return list;
	}

	@Override
	public void update(long id, Class_Registration cls) {
		 Session session = sessionFactory.getCurrentSession();
		 Class_Registration clas2 = session.byId(Class_Registration.class).load(id);
		clas2.setCls(cls.getCls());
		clas2.setStudent(cls.getStudent());
	    
	     session.flush();
	}

	@Override
	public void delete(long id) {
		Class_Registration cls= sessionFactory.getCurrentSession().byId(Class_Registration.class).load(id);
	      sessionFactory.getCurrentSession().delete(cls);
		
	}

	@Override
	public ca.uwindsor.mac.model.Class getClassByStudentId(long sid) {
		List<ca.uwindsor.mac.model.Class_Registration> list = sessionFactory.getCurrentSession().createQuery("from CLASS_REGISTRATION WHERE STUDENT_STUDENT_ID="+sid).list();
	    //  return list.get(0).getRank();
		return list.get(0).getCls();
	}

	@Override
	public ArrayList<Long> getStudentByClassId(int cid) {
		ArrayList<Long> lst=new ArrayList<Long>();
		List<ca.uwindsor.mac.model.Class_Registration> list = sessionFactory.getCurrentSession().createQuery("from CLASS_REGISTRATION WHERE CLS_CLASS_ID="+cid).list();
	   for(Class_Registration c: list) {
		   lst.add(c.getStudent().getStudent_id());
	   }
	   return lst;
	}

}
