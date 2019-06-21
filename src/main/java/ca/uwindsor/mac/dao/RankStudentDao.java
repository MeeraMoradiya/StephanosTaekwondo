package ca.uwindsor.mac.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;;

public interface RankStudentDao {
	long save(Rank_Student rank);

	Rank_Student get(long id);

	List<Rank_Student> list();

	void update(long id, Rank_Student rank);

	void delete(long id);
	
	Rank getRankByStudent(Student s);
	
	Date getRankDateByStudentId(long id);
	
	public ArrayList<Long> getStudentIdByRankId(Long rank);
	
	public Long getRelationBySidAndRid(Long sid, Long rid);
}
