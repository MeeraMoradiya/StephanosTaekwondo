package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Class_Registration;;

public interface ClassRegistrationService {
	long save(Class_Registration cls);

	Class_Registration get(long id);

	List<Class_Registration> list();

	void update(long id, Class_Registration cls);

	void delete(long id);
	
	ca.uwindsor.mac.model.Class getClassByStudentId(long sid);
}
