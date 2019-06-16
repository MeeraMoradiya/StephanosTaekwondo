package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.ClassDao;
import ca.uwindsor.mac.model.Class;

@Service
@Transactional(readOnly = true)
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassDao classDao;
	
	@Override
	public long save(Class cls) {
		return classDao.save(cls);
	}

	@Override
	public Class get(long id) {
		return classDao.get(id);
	}

	@Override
	public List<Class> list() {
		return classDao.list();
	}

	@Override
	public void update(long id, Class cls) {
		classDao.update(id, cls);
		
	}

	@Override
	public void delete(long id) {
		classDao.delete(id);
		
	}

}
