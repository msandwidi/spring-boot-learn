package com.shoudou.boot.crudstarter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shoudou.boot.crudstarter.entity.Employee;
import com.shoudou.boot.crudstarter.repository.EmployeeRepository;

@Service // the service delegate the calls to the DAO
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepo) {
		this.employeeRepository = employeeRepo;
	}

	@Override
	// @Transactional //provided by default with spring data jpa
	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> result = employeeRepository.findById(id);
		Employee employee = null;
		if (result.isPresent())
			employee = result.get();
		else
			throw new RuntimeException("Employee " + id + " not found");
		return employee;
	}

	@Override
	public void save(Employee emp) {
		employeeRepository.save(emp);

	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);

	}

}
