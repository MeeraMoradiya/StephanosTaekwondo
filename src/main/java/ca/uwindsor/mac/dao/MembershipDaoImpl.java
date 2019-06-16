package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Class_Registration;
import ca.uwindsor.mac.model.Membership;

@Repository
public class MembershipDaoImpl implements MembershipDao{
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public long save(Membership mem) {
		
		sessionFactory.getCurrentSession().save(mem);
	      return mem.getMembership_id();
	}

	@Override
	public Membership get(long id) {
		return sessionFactory.getCurrentSession().get(Membership.class, id);
	}

	@Override
	public List<Membership> list() {
		List<Membership> list = sessionFactory.getCurrentSession().createQuery("from MEMBERSHIP").list();
	      return list;
	}

	@Override
	public void update(long id, Membership mem) {
		 Session session = sessionFactory.getCurrentSession();
		 Membership mem2 = session.byId(Membership.class).load(id);
		 mem2.setM_startDate(mem.getM_startDate());
		 mem2.setM_endDate(mem.getM_endDate());
		 mem2.setM_cost(mem.getM_cost());
		 mem2.setStudent(mem.getStudent());
	    
	     session.flush();
	}

	@Override
	public void delete(long id) {
		Membership mem= sessionFactory.getCurrentSession().byId(Membership.class).load(id);
	      sessionFactory.getCurrentSession().delete(mem);
		
	}

}
