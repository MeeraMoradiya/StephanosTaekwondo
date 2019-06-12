package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.ParentDao;
import ca.uwindsor.mac.model.Parent;

@Service
@Transactional(readOnly = true)
public class ParentServiceImpl implements ParentService {
	
	@Autowired
	private ParentDao parentDao;

	@Override
	public long save(Parent parent) {
		return parentDao.save(parent);
	}

	@Override
	public Parent get(long id) {
		return parentDao.get(id);
	}

	@Override
	public List<Parent> list() {
		return parentDao.list();
	}

	@Override
	public void update(long id, Parent parent) {
		parentDao.update(id, parent);
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		parentDao.delete(id);
	}

}
