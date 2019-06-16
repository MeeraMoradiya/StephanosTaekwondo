package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Parent;

public interface ParentDao {
	
	long save(Parent parent);

	Parent get(long id);

	List<Parent> list();

	void update(long id, Parent parent);

	void delete(long id);

}
