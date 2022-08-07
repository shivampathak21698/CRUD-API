package com.lu2code.springboot.crudapi.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lu2code.springboot.crudapi.entity.Employee;

@Repository
public class EmployeeDAOHibernateImp implements EmployeeDAO {
	
	// EntityManager
	@Autowired
	private EntityManager entityManager;	


	@Override
	public List<Employee> getEmployees() {
		
		// Get Hibernate Session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create Query
		Query<Employee> theQuery = currentSession.createQuery("from Employee");
		
		// Execute Query
		List<Employee> employee = theQuery.getResultList();
		
		// Return Result		
		return employee;
	}

	@Override
	public Employee getEmployee(int theID) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {
			Query theQuery = currentSession.createQuery("from Employee where id=:employeeID");
			theQuery.setParameter("employeeID", theID);
			Employee theEmployee = (Employee) theQuery.getSingleResult();
			return theEmployee;
			
		}finally {
			
		}
		
		
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		try {
			
			currentSession.saveOrUpdate(theEmployee);
			
		}finally {
			
		}
		
	}

	@Override
	public void delete(int theID) {
	
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeID");
		theQuery.setParameter("employeeID", theID);
		theQuery.executeUpdate();
		
	}

	

}
