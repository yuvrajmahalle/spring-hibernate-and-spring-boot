package com.ashish.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ashish.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		
		Query theQuery = 
				entityManager.createQuery("from Employee");
		
		List<Employee> employees = theQuery.getResultList();
		 
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		// get employee
		Employee theEmployee =
					entityManager.find(Employee.class, theId);
		
		//return employee
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		Employee dbEmployee =
					entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = 
					entityManager.createQuery(
							"delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId",theId);
		
		theQuery.executeUpdate();
	}

}
