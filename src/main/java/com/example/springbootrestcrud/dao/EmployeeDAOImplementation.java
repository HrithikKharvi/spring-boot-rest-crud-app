package com.example.springbootrestcrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.springbootrestcrud.entity.Employee;

@Repository()
public class EmployeeDAOImplementation implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	//Constructor Injection, which automatically inject the EntityManager object 
	@Autowired()
	public EmployeeDAOImplementation(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	//Labeled with @Transactional so it will create session for us
	@Override
	public List<Employee> findAll(){
		
		Session session = this.entityManager.unwrap(Session.class);
		
		Query<Employee> query = session.createQuery("FROM Employee");
		
		List<Employee> employees = query.list();
		
		return employees;
	}
	
	
	@Override
	public Employee findByID(int id) {
		//Get the session to retrieve data from Database
		
		Session session = entityManager.unwrap(Session.class);
		
		//Find the Employee
		Employee employee = session.get(Employee.class, id);
		
		return employee;
	}
	
	@Override
	public boolean save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(employee);
		return true;
	}
	
	@Override
	public boolean delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("DELETE FROM Employee WHERE id=:employeeID");
		query.setParameter("employeeID", id);
		
		query.executeUpdate();
		
		return true;
	}
}
