package com.lu2code.springboot.crudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lu2code.springboot.crudapi.dao.EmployeeDAO;
import com.lu2code.springboot.crudapi.entity.Employee;

@Service
public class EmployeeServiceHibernateService implements EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		
		List<Employee> theEmployee = employeeDAO.getEmployees();
		
		return theEmployee;
	}

	@Override
	@Transactional
	public Employee getEmployee(int theID) {
		
		Employee theEmployee = employeeDAO.getEmployee(theID);
		
		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		
		employeeDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void delete(int theID) {
		
		employeeDAO.delete(theID);
	}


}
