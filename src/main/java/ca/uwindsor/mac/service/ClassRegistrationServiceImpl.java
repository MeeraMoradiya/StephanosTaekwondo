package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.ClassRegistrationDao;
import ca.uwindsor.mac.model.Class_Registration;

@Service
@Transactional(readOnly = true)
public class ClassRegistrationServiceImpl implements ClassRegistrationService {
	
	@Autowired
	private ClassRegistrationDao clsDao;

	@Override
	public long save(Class_Registration cls) {
		return clsDao.save(cls);
	}

	@Override
	public Class_Registration get(long id) {
		return clsDao.get(id);
	}

	@Override
	public List<Class_Registration> list() {
		return clsDao.list();
	}

	@Override
	public void update(long id, Class_Registration cls) {
		clsDao.update(id, cls);
		
	}

	@Override
	public void delete(long id) {
		clsDao.delete(id);
		
	}

	@Override
	public ca.uwindsor.mac.model.Class getClassByStudentId(long sid) {
		return clsDao.getClassByStudentId(sid);
	}

}
