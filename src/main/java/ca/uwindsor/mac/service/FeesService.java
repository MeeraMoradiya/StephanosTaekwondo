package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Fees;

public interface FeesService {
	long save(Fees fees);

	Fees get(long id);

	List<Fees> list();

	void update(long id, Fees fees);

	
	void delete(long id);
	
	Fees getFeesByStudentId(long sid);
}
