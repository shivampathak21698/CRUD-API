package com.lu2code.springboot.crudapi.dao;

import java.util.List;

import com.lu2code.springboot.crudapi.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployees();

	public Employee getEmployee(int theID);
	
	public void save(Employee theEmployee);
	
	public void delete(int theID);
}
