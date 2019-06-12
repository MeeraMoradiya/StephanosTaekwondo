package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Parent;


@Repository
public class ParentDaoImpl implements ParentDao {
	
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Parent parent) {
		sessionFactory.getCurrentSession().save(parent);
	      return parent.getParent_id();
	}

	@Override
	public Parent get(long id) {
		return sessionFactory.getCurrentSession().get(Parent.class, id);
	}

	@Override
	public List<Parent> list() {
		List<Parent> list = sessionFactory.getCurrentSession().createQuery("from PARENT").list();
	      return list;
	}

	@Override
	public void update(long id, Parent parent) {
		 Session session = sessionFactory.getCurrentSession();
	     Parent parent2 = session.byId(Parent.class).load(id);
	     parent2.setParent_name(parent.getParent_name());
	     parent2.setParent_phone(parent.getParent_phone());
	     parent2.setParent_email(parent.getParent_email());
	     session.flush();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		Parent parent= sessionFactory.getCurrentSession().byId(Parent.class).load(id);
	      sessionFactory.getCurrentSession().delete(parent);
	}

}
