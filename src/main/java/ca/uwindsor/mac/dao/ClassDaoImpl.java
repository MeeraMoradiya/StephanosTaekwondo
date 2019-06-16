package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Class;
import ca.uwindsor.mac.model.Parent;

@Repository
public class ClassDaoImpl implements ClassDao{
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Class cls) {
		sessionFactory.getCurrentSession().save(cls);
	      return cls.getClass_id();
	}

	@Override
	public Class get(long id) {
		return sessionFactory.getCurrentSession().get(Class.class, id);
	}

	@Override
	public List<Class> list() {
		List<Class> list = sessionFactory.getCurrentSession().createQuery("from T_CLASS").list();
	      return list;
	}

	@Override
	public void update(long id, Class cls) {
		 Session session = sessionFactory.getCurrentSession();
		 Class clas2 = session.byId(Class.class).load(id);
		 clas2.setClass_date(cls.getClass_date());
		 clas2.setStartTime(cls.getStartTime());
		 clas2.setEndTime(cls.getEndTime());
		 clas2.setLevel(cls.getLevel());
	    
	     session.flush();
	}

	@Override
	public void delete(long id) {
		Class cls= sessionFactory.getCurrentSession().byId(Class.class).load(id);
	      sessionFactory.getCurrentSession().delete(cls);
		
	}

}
