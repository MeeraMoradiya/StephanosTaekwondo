package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Parent;


public interface ParentService {
	
	long save(Parent parent);
	 Parent get(long id);
	   List<Parent> list();
	   void update(long id, Parent parent);
	   void delete(long id);


}
