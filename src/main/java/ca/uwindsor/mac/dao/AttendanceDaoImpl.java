package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Attendance;
import ca.uwindsor.mac.model.Class;
import ca.uwindsor.mac.model.Rank_Student;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {
	
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public void save(Attendance at) {
		sessionFactory.getCurrentSession().save(at);
	    
	}

	@Override
	public Attendance get(long id) {
		return sessionFactory.getCurrentSession().get(Attendance.class, id);
	}

	@Override
	public List<Attendance> list() {
		List<Attendance> list = sessionFactory.getCurrentSession().createQuery("from ATTENDANCE").list();
	      return list;
	}

	@Override
	public void update(long id, Attendance at) {
		 Session session = sessionFactory.getCurrentSession();
		 Attendance at2 = session.byId(Attendance.class).load(id);
		at2.setA_dateTime(at.getA_dateTime());
		at2.setCls(at.getCls());
		at2.setStudent(at.getStudent());
		session.flush();
		
	}

	@Override
	public void delete(long id) {
		Attendance at= sessionFactory.getCurrentSession().byId(Attendance.class).load(id);
	      sessionFactory.getCurrentSession().delete(at);
		
	}

	@Override
	public int getAttandanceCountByStudent(long sid) {
		List<Rank_Student> list = sessionFactory.getCurrentSession().createQuery("from ATTANDENCE WHERE STUDENT_STUDENT_ID="+sid).list();
	      return list.size();
	}

}
