package ca.uwindsor.mac.dao;

import java.util.List;
import ca.uwindsor.mac.model.Class;


public interface ClassDao {
	long save(Class cls);

	Class get(long id);

	List<Class> list();

	void update(long id, Class cls);

	void delete(long id);
}
