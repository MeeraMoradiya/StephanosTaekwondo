package ca.uwindsor.mac.service;

import java.util.List;
import ca.uwindsor.mac.model.Class;



public interface ClassService {
	long save(Class cls);

	Class get(long id);

	List<Class> list();

	void update(long id, Class cls);

	void delete(long id);
}
