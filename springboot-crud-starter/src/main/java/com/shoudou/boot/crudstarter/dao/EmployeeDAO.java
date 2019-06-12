package com.shoudou.boot.crudstarter.dao;

import java.util.List;

import com.shoudou.boot.crudstarter.entities.Employee;

public interface EmployeeDAO {
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee emp);
	public void deleteById(int id);
}
