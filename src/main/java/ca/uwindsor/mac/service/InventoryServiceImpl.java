package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.InventoryDao;
import ca.uwindsor.mac.model.Inventory;

@Service
@Transactional(readOnly = true)
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryDao invDao;
	
	@Override
	public long save(Inventory inv) {
		return invDao.save(inv);
	}

	@Override
	public Inventory get(long id) {
		
		return invDao.get(id);
	}

	@Override
	public List<Inventory> list() {
		
		return invDao.list();
	}

	@Override
	public void update(long id, Inventory inv) {
		invDao.update(id, inv);
		
	}

	@Override
	public void delete(long id) {
		invDao.delete(id);
		
	}

	@Override
	public Inventory getInventoryByName(String name) {
		return invDao.getInventoryByName(name);
	}

	
}
