package ca.uwindsor.mac.service;

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
	


}
