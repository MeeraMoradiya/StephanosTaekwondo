package ca.uwindsor.mac.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.RankStudentDao;
import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;

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

	@Override
	public Rank getRankByStudent(Student s) {
		return rsDao.getRankByStudent(s);
	}

	@Override
	public Date getRankDateByStudentId(long sid) {
		return rsDao.getRankDateByStudentId(sid);
	}

	@Override
	public ArrayList<Long> getStudentIdByRankId(Long rank) {
		// TODO Auto-generated method stub
		return rsDao.getStudentIdByRankId(rank);
	}

	@Override
	public Long getRelationBySidAndRid(Long sid, Long rid) {
		// TODO Auto-generated method stub
		return rsDao.getRelationBySidAndRid(sid,rid);
	}

	
	
}
