package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Order;



public interface OrderService {
	long save(Order order);

	Order get(long id);

	List<Order> list();

	void update(long id, Order order);

	void delete(long id);
}
