package com.ashish.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
