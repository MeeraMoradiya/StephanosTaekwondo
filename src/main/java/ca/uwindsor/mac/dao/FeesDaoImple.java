package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Class;
import ca.uwindsor.mac.model.Fees;
import ca.uwindsor.mac.model.Membership;

@Repository
public class FeesDaoImple implements FeesDao{

	 @Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public long save(Fees fees) {
		sessionFactory.getCurrentSession().save(fees);
	      return fees.getF_id();
	}

	@Override
	public Fees get(long id) {
		return sessionFactory.getCurrentSession().get(Fees.class, id);
	}

	@Override
	public List<Fees> list() {
		List<Fees> list = sessionFactory.getCurrentSession().createQuery("from FEES").list();
	      return list;
	}

	@Override
	public void update(long id, Fees fees) {
		 Session session = sessionFactory.getCurrentSession();
		 Fees f2 = session.byId(Fees.class).load(id);
		f2.setF_date(fees.getF_date());
		f2.setF_amount(fees.getF_amount());
		f2.setF_term(fees.getF_term());
		f2.setStudent(fees.getStudent());
	     session.flush();
		
	}

	@Override
	public void delete(long id) {
		Fees fees= sessionFactory.getCurrentSession().byId(Fees.class).load(id);
	      sessionFactory.getCurrentSession().delete(fees);
		
	}

	@Override
	public Fees getFeesByStudentId(long sid) {
		List<Fees> list = sessionFactory.getCurrentSession().createQuery("from FEES WHERE STUDENT_STUDENT_ID="+sid).list();
	      return list.get(0);
	}

}
