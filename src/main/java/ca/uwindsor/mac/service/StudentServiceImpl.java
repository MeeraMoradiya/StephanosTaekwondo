package ca.uwindsor.mac.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.StudentDao;
import ca.uwindsor.mac.model.Student;

@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public long save(Student student) {
		// TODO Auto-generated method stub
		return studentDao.save(student);
	}

	@Override
	public Student get(long id) {
		// TODO Auto-generated method stub
		return studentDao.get(id);
	}

	@Override
	public List<Student> list() {
		// TODO Auto-generated method stub
		return studentDao.list();
		
	}

	@Override
	public void update(long id, Student student) {
		// TODO Auto-generated method stub
		studentDao.update(id, student);
	}

	@Override
	public void delete(long id) {
		studentDao.delete(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Long> getStudentListByDOJ(java.sql.Date fromDate, java.sql.Date toDate) {
		return studentDao.getStudentListByDOJ(fromDate, toDate);
	}

	@Override
	public ArrayList<Long> getStudentListByCity(String city) {
		return studentDao.getStudentListByCity(city);
	}

	@Override
	public ArrayList<Long> getStudentListByStatus(String status) {
		return studentDao.getStudentListByStatus(status);
	}
	


}
