package com.shoudou.boot.crudstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoudou.boot.crudstarter.dao.EmployeeDAO;
import com.shoudou.boot.crudstarter.entities.Employee;

@Service // the service delegate the calls to the DAO
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {

		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {

		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Employee emp) {
		employeeDAO.save(emp);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDAO.deleteById(id);

	}

}
