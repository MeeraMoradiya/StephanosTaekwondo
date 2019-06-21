package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.AttendanceDao;
import ca.uwindsor.mac.model.Attendance;
@Service
@Transactional(readOnly = true)
public class AttendanceSeviceImpl implements AttandenceService{

	@Autowired
	private AttendanceDao atDao;
	
	@Override
	public void save(Attendance at) {
		atDao.save(at);
	}

	@Override
	public Attendance get(long id) {
		return atDao.get(id);
	}

	@Override
	public List<Attendance> list() {
		return atDao.list();
	}

	@Override
	public void update(long id, Attendance at) {
		atDao.update(id, at);
		
	}

	@Override
	public void delete(long id) {
		atDao.delete(id);
		
	}

	@Override
	public int getAttendanceByStudent(long sid) {
		return atDao.getAttandanceCountByStudent(sid);
	}

}
