package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.MembershipDao;
import ca.uwindsor.mac.model.Membership;
@Service
@Transactional(readOnly = true)
public class MembershipServiceImpl implements MembershipService{

	@Autowired
	private MembershipDao memDao;
	@Override
	public long save(Membership mem) {
		return memDao.save(mem);
	}

	@Override
	public Membership get(long id) {
		return memDao.get(id);
	}

	@Override
	public List<Membership> list() {
		return memDao.list();
	}

	@Override
	public void update(long id, Membership mem) {
		memDao.update(id, mem);
		
	}

	@Override
	public void delete(long id) {
		memDao.delete(id);
		
	}

	

}
