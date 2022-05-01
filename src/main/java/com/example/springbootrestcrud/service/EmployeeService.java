package com.example.springbootrestcrud.service;

import java.util.List;

import com.example.springbootrestcrud.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	boolean save(Employee employee);
	
	boolean delete(int id);
	
}
