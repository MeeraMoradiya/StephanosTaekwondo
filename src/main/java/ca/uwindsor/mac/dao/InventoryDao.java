package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Inventory;



public interface InventoryDao {
	
	long save(Inventory inv);

	Inventory get(long id);

	List<Inventory> list();

	void update(long id, Inventory inv);

	void delete(long id);
	
	Inventory getInventoryByName(String name);
	
	

}
