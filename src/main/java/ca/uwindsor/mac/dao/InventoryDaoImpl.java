package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Inventory;
import ca.uwindsor.mac.model.Parent;
import ca.uwindsor.mac.model.Student;

@Repository
public class InventoryDaoImpl implements InventoryDao{
	
	 @Autowired
	   private SessionFactory sessionFactory;

	@Override
	public long save(Inventory inv) {
		sessionFactory.getCurrentSession().save(inv);
	      return inv.getInventory_Id();
	}

	@Override
	public Inventory get(long id) {
		return sessionFactory.getCurrentSession().get(Inventory.class, id);
	}

	@Override
	public List<Inventory> list() {
		List<Inventory> list = sessionFactory.getCurrentSession().createQuery("from INVENTORY").list();
	      return list;
	}

	@Override
	public void update(long id, Inventory inv) {
		 Session session = sessionFactory.getCurrentSession();
		 Inventory inv2 = session.byId(Inventory.class).load(id);
	    inv2.setInventory_name(inv.getInventory_name());
	    inv2.setInventory_desc(inv.getInventory_desc());
	    inv2.setCost_price(inv.getCost_price());
	    inv2.setSelling_price(inv.getSelling_price());
	    inv2.setStock(inv.getStock());
	     session.flush();
		
	}

	@Override
	public void delete(long id) {
		Inventory inv= sessionFactory.getCurrentSession().byId(Inventory.class).load(id);
	      sessionFactory.getCurrentSession().delete(inv);
		
	}

	@Override
	public Inventory getInventoryByName(String name) {
		List<Inventory> list = sessionFactory.getCurrentSession().createQuery("from INVENTORY WHERE INVENTORY_NAME="+name).list();
		return list.get(0);
	}

	

}
