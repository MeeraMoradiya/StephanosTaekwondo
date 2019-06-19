package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.RankStudentDao;
import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;

@Service
@Transactional(readOnly = true)
public class RankStudentServiceImpl implements RankStudentService {

	@Autowired
	private RankStudentDao rsDao;

	@Override
	public long save(Rank_Student rs) {
		return rsDao.save(rs);
	}

	@Override
	public Rank_Student get(long id) {
		return rsDao.get(id);
	}

	@Override
	public List<Rank_Student> list() {
		return rsDao.list();
	}

	@Override
	public void update(long id, Rank_Student rs) {
		rsDao.update(id,rs);
	}

	@Override
	public void delete(long id) {
		rsDao.delete(id);
		
	}

	
	
}
