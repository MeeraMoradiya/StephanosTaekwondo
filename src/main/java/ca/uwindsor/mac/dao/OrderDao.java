package ca.uwindsor.mac.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ca.uwindsor.mac.model.Order;


public interface OrderDao {
	long save(Order order);

	Order get(long id);

	List<Order> list();

	void update(long id, Order order);

	void delete(long id);

}
