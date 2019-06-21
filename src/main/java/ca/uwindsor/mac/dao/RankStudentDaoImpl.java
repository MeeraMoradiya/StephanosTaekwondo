package ca.uwindsor.mac.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;
import ca.uwindsor.mac.model.Student_Parent;

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

	public ArrayList<Long> getStudentIdByRankId(Long rank) {
		ArrayList<Long> lst=new ArrayList<Long>();
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from RANK_STUDENT WHERE RANK_RANK_ID="+rank).list();
	     for(Rank_Student rs : list) {
	    	 lst.add(rs.getStudent().getStudent_id());
	     }
	     return lst;
	}
	
	@Override
	public Date getRankDateByStudentId(long id) {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from RANK_STUDENT WHERE STUDENT_STUDENT_ID="+id).list();
	      return list.get(0).getRank_date();
	}

	@Override
	public Long getRelationBySidAndRid(Long sid, Long rid) {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from STUDENT_RANK WHERE STUDENT_STUDENT_ID="+sid+" AND RANK_RANK_ID="+rid).list();
	    //  return list.get(0).getRank();
		return list.get(0).getRS_id();
	}
	
	}
