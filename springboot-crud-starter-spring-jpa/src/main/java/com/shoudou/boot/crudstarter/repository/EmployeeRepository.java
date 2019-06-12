package com.shoudou.boot.crudstarter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoudou.boot.crudstarter.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
