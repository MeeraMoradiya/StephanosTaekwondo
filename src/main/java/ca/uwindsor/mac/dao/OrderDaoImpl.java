package ca.uwindsor.mac.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Inventory;
import ca.uwindsor.mac.model.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Order order) {
		sessionFactory.getCurrentSession().save(order);
		return order.getOrder_id();
	}

	@Override
	public Order get(long id) {
		return sessionFactory.getCurrentSession().get(Order.class, id);
	}

	@Override
	public List<Order> list() {
		List<Order> list = sessionFactory.getCurrentSession().createQuery("from ORDERD_ITEMS").list();
		return list;
	}

	@Override
	public void update(long id, Order order) {
		Session session = sessionFactory.getCurrentSession();
		Order order2 = session.byId(Order.class).load(id);
		order2.setOrder_date(order.getOrder_date());
		order2.setQty(order.getQty());
		order2.setStudent(order.getStudent());
		order2.setInv(order.getInv());
		session.flush();

	}

	@Override
	public void delete(long id) {
		Order order = sessionFactory.getCurrentSession().byId(Order.class).load(id);
		sessionFactory.getCurrentSession().delete(order);

	}

}
