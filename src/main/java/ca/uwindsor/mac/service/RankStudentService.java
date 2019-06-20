package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Rank;
import ca.uwindsor.mac.model.Rank_Student;
import ca.uwindsor.mac.model.Student;;

public interface RankStudentService {
	
	long save(Rank_Student rs);
	Rank_Student get(long id);
	   List<Rank_Student> list();
	   void update(long id, Rank_Student rs);
	   void delete(long id);
       Rank getRankByStudent(Student s);
       
}
