package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Fees;

public interface FeesDao {
	long save(Fees fees);

	Fees get(long id);

	List<Fees> list();

	void update(long id, Fees fees);

	void delete(long id);
}
