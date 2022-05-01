package com.example.springbootrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootrestcrud.dao.EmployeeDAO;
import com.example.springbootrestcrud.entity.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImplementation(EmployeeDAO dao) {
		this.employeeDAO = dao;
	}
	
	@Transactional
	@Override
	public List<Employee> findAll(){
		return employeeDAO.findAll();
	}
	
	@Override
	@Transactional
	public Employee findById(int id) {
		return employeeDAO.findByID(id);
	}
	
	@Override
	@Transactional
	public boolean save(Employee employee) {
		return employeeDAO.save(employee);
	}
	
	@Override
	@Transactional
	public boolean delete(int id) {
		return employeeDAO.delete(id);
	}
	
	
}
