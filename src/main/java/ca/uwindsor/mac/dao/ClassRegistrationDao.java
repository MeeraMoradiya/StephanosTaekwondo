package ca.uwindsor.mac.dao;

import java.util.ArrayList;
import java.util.List;

import ca.uwindsor.mac.model.Class_Registration;;

public interface ClassRegistrationDao {
	long save(Class_Registration cls);

	Class_Registration get(long id);

	List<Class_Registration> list();

	void update(long id, Class_Registration cls);

	void delete(long id);
	
	ca.uwindsor.mac.model.Class getClassByStudentId(long sid);
	
	ArrayList<Long> getStudentByClassId(int cid);
}
