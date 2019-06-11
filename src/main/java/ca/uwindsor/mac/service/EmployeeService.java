package ca.uwindsor.mac.service;

import java.util.List;

import ca.uwindsor.mac.model.Employee;

public interface EmployeeService {
	
	 long save(Employee book);
	 Employee get(long id);
	   List<Employee> list();
	   void update(long id, Employee book);
	   void delete(long id);

}
