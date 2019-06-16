package ca.uwindsor.mac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.uwindsor.mac.dao.OrderDao;
import ca.uwindsor.mac.model.Order;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService  {
	
	@Autowired
	private OrderDao orderDao;

	@Override
	public long save(Order order) {
		return orderDao.save(order);
	}

	@Override
	public Order get(long id) {
		return orderDao.get(id);
	}

	@Override
	public List<Order> list() {
		return orderDao.list();
	}

	@Override
	public void update(long id, Order order) {
		orderDao.update(id, order);
		
	}

	@Override
	public void delete(long id) {
		orderDao.delete(id);
		
	}

}
