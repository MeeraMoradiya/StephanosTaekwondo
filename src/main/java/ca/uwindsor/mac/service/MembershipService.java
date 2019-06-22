package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Membership;

public interface MembershipService {
	long save(Membership mem);

	Membership get(long id);

	List<Membership> list();

	void update(long id, Membership mem);

	void delete(long id);
	
  
}
