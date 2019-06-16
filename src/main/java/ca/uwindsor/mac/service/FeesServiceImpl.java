package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.FeesDao;
import ca.uwindsor.mac.model.Fees;
@Service
@Transactional(readOnly = true)
public class FeesServiceImpl implements FeesService {

	private FeesDao fDao;
	
	@Override
	public long save(Fees fees) {
		return fDao.save(fees);
	}

	@Override
	public Fees get(long id) {
		return fDao.get(id);
	}

	@Override
	public List<Fees> list() {
		return fDao.list();
	}

	@Override
	public void update(long id, Fees fees) {
		fDao.update(id, fees);
	}

	@Override
	public void delete(long id) {
		fDao.delete(id);
		
	}

}
