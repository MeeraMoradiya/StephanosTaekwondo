package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Membership;

public interface MembershipDao {
	long save(Membership mem);

	Membership get(long id);

	List<Membership> list();

	void update(long id, Membership mem);

	void delete(long id);
	
	
}
