package ca.uwindsor.mac.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;

@Repository
public class RankStudentDaoImpl implements RankStudentDao{

	
	 @Autowired
	   private SessionFactory sessionFactory;
	
	@Override
	public long save(Rank_Student rank) {
		sessionFactory.getCurrentSession().save(rank);
	      return rank.getRS_id();
	}

	@Override
	public Rank_Student get(long id) {
		return sessionFactory.getCurrentSession().get(Rank_Student.class, id);
	}

	@Override
	public List<Rank_Student> list() {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from RANK_STUDENT").list();
	      return list;
	}

	@Override
	public void update(long id, Rank_Student rank) {
		 Session session = sessionFactory.getCurrentSession();
		 Rank_Student rank2 = session.byId(Rank_Student.class).load(id);
	    rank2.setRank(rank.getRank());
	    rank2.setStudent(rank.getStudent());
	    rank2.setRank_date(rank.getRank_date());
	     session.flush();
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rank getRankByStudent(Student s) {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from RANK_STUDENT WHERE STUDENT_STUDENT_ID="+s.getStudent_id()).list();
	      return list.get(0).getRank();
	}

	@Override
	public Date getRankDateByStudentId(long id) {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from RANK_STUDENT WHERE STUDENT_STUDENT_ID="+id).list();
	      return list.get(0).getRank_date();
	}
	
	

}
