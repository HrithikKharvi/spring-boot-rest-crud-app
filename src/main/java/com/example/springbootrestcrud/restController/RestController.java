package com.example.springbootrestcrud.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.springbootrestcrud.entity.Employee;
import com.example.springbootrestcrud.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		return employeeService.findAll();
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") int id) {
		Employee employee = employeeService.findById(id);
		
		if(employee == null) {
			throw new RuntimeException("Employee not found! with id : " + id);
		}
		
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		
	    employeeService.save(employee);
	    return employee;
	}
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID) {
		Employee employee = employeeService.findById(employeeID);
		if(employee == null) throw new RuntimeException("Employee not found");
		employeeService.delete(employeeID);
		return "Employee deleted with id : " + employeeID;
	}
	
	
	
	
}
