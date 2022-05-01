package com.example.springbootrestcrud.dao;

import java.util.List;

import com.example.springbootrestcrud.entity.Employee;

public interface EmployeeDAO {
	
	//Get the list of all the Employees that is stored in the database
	List<Employee> findAll();
	
	//Get the Single employee based on the 'id'
	Employee findByID(int id);
	
	//Save the Employee to the Database
	boolean save(Employee employee);
	
	//Delete Employee from the Database using 'id'
	
	boolean delete(int id);
	
	
}
