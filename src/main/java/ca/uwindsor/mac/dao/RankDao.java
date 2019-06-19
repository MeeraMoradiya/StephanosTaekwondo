package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Rank;

public interface RankDao {
	long save(Rank rank);

	Rank get(long id);

	List<Rank> list();

	void update(long id, Rank rank);

	void delete(long id);
}
