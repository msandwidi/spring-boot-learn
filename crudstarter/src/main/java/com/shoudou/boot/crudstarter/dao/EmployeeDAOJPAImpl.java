package com.shoudou.boot.crudstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoudou.boot.crudstarter.entities.Employee;
/*
 * DAO Using JPA 
 */
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	// define entity manager
	private EntityManager entityManager;

	// set up constructor injection; can instead use field injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the hibernate session
		//Session currentSession = this.entityManager.unwrap(Session.class);

		// create query
		Query query = this.entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = query.getResultList();

		return employees;
	}

	@Override
	public Employee findById(int id) {
	
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = this.entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);

	}

	@Override
	public void deleteById(int id) {
		Session currentSession = this.entityManager.unwrap(Session.class);
		Query query = currentSession
				.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
