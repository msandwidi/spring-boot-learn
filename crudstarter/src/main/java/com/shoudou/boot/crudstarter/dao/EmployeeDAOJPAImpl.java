package com.shoudou.boot.crudstarter.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoudou.boot.crudstarter.entities.Employee;

/*
 * DAO Using JPA 
 */
@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {
	// define entity manager
	//@Autowired,, @Inject, @Resource or @PersistenceContext
	private EntityManager entityManager;

	// set up constructor injection; can instead use field injection
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get the hibernate session
		// Session currentSession = this.entityManager.unwrap(Session.class);

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
		Employee dbEmployee = this.entityManager.merge(employee);

		employee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int id) {
		Query query = this.entityManager.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", id);
		query.executeUpdate();
	}

}
