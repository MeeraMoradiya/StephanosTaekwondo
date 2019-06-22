package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Inventory;

public interface InventoryService {
	long save(Inventory inv);

	Inventory get(long id);

	List<Inventory> list();

	void update(long id, Inventory inv);

	void delete(long id);
	
	
	
	

}
