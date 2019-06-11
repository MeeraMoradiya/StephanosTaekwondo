package ca.uwindsor.mac.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import ca.uwindsor.mac.dao.*;
import ca.uwindsor.mac.model.Book;
import ca.uwindsor.mac.model.Employee;



public class EmployeeDaoImpl implements EmployeeDao {
	
	 @Autowired
	   private SessionFactory sessionFactory;
	// Saving a new Employee
    public void saveEmployee(Employee employee)
    {
    	sessionFactory.getCurrentSession().save(employee);
        
    }

    // Getting a particular Employee		
    public Employee getEmployeeById(int id)
    {
    	 return sessionFactory.getCurrentSession().get(Employee.class, id);
    }

    // Getting all the Employees
    public List<Employee> getAllEmployees()
    {
    	 List<Employee> list = sessionFactory.getCurrentSession().createQuery("from Employee").list();
         return list;
    }

    // Updating a particular Employee
    public void updateEmployee(Employee employee)
    {
       
    }

    // Deletion of a particular Employee
    public void deleteEmployee(int id)
    {
       
    }
}
