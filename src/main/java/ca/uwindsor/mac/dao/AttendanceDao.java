package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Attendance;

public interface AttendanceDao {
	void save(Attendance at);

	Attendance get(long id);

	List<Attendance> list();

	void update(long id, Attendance at);

	void delete(long id);
}
