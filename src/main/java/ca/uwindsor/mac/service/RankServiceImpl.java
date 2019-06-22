package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.RankDao;
import ca.uwindsor.mac.model.Rank;

@Service
@Transactional(readOnly = true)
public class RankServiceImpl implements RankService{

	@Autowired
	private RankDao rankDao;
	
	@Override
	public long save(Rank rank) {
		return rankDao.save(rank);
	}

	@Override
	public Rank get(long id) {
		
		return rankDao.get(id);
	}

	@Override
	public List<Rank> list() {
		return rankDao.list();
	}

	@Override
	public void update(long id, Rank rank) {
		rankDao.update(id, rank);
		
	}

	@Override
	public void delete(long id) {
		rankDao.delete(id);
		
	}

	@Override
	public Rank getRankByBelt(String rank) {
		return rankDao.getRankByBelt(rank);
	}
	
	

}
