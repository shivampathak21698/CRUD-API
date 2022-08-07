package com.lu2code.springboot.crudapi.service;

import java.util.List;

import com.lu2code.springboot.crudapi.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee getEmployee(int theID);
	
	public void save(Employee theEmployee);
	
	public void delete(int theID);
	
}
