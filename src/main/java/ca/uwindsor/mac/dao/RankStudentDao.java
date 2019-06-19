package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Rank_Student;;

public interface RankStudentDao {
	long save(Rank_Student rank);

	Rank_Student get(long id);

	List<Rank_Student> list();

	void update(long id, Rank_Student rank);

	void delete(long id);
}
