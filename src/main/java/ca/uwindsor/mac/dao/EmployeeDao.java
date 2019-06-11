package ca.uwindsor.mac.dao;

import java.util.List;

import ca.uwindsor.mac.model.Employee;



public interface EmployeeDao {
	public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    public void updateEmployee(Employee employee);
    public void deleteEmployee(int id);
    public List getAllEmployees();
}
