package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Rank;

@Repository
public class RankDaoImpl implements RankDao {

	 @Autowired
	   private SessionFactory sessionFactory;
	 
	@Override
	public long save(Rank rank) {
		sessionFactory.getCurrentSession().save(rank);
	      return rank.getRankId();
	}

	@Override
	public Rank get(long id) {
		return sessionFactory.getCurrentSession().get(Rank.class, id);
	}

	@Override
	public List<Rank> list() {
		List<Rank> list = sessionFactory.getCurrentSession().createQuery("from RANK").list();
	      return list;
	}

	@Override
	public void update(long id, Rank rank) {
		 Session session = sessionFactory.getCurrentSession();
	     Rank rank2 = session.byId(Rank.class).load(id);
	     rank2.setBeltColour(rank.getBeltColour());
	     session.flush();
	}

	@Override
	public void delete(long id) {
		Rank rank= sessionFactory.getCurrentSession().byId(Rank.class).load(id);
	      sessionFactory.getCurrentSession().delete(rank);
		
	}

}
