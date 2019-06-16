package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.Student_Parent_Dao;
import ca.uwindsor.mac.model.Student_Parent;

@Service
@Transactional(readOnly = true)
public class Student_Parent_ServiceImpl implements Student_Parent_Service {
	
	@Autowired
	private Student_Parent_Dao sp_dao;

	@Override
	public long save(Student_Parent sp) {
		// TODO Auto-generated method stub
		return sp_dao.save(sp);
	}

	@Override
	public Student_Parent get(long id) {
		// TODO Auto-generated method stub
		return sp_dao.get(id);
	}

	@Override
	public List<Student_Parent> list() {
		// TODO Auto-generated method stub
		return sp_dao.list();
	}

	@Override
	public void update(long id, Student_Parent sp) {
		// TODO Auto-generated method stub
		sp_dao.update(id,sp);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		sp_dao.delete(id);
		
	}

}
