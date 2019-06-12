package com.shoudou.boot.crudstarter.service;

import java.util.List;

import com.shoudou.boot.crudstarter.entities.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int id);

	public void save(Employee emp);

	public void deleteById(int id);
}
