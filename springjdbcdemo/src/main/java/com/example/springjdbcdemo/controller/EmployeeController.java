package com.example.springjdbcdemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springjdbcdemo.dao.EmployeeDao;
import com.example.springjdbcdemo.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao edao;
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return edao.getAll();
		
	}
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return edao.getById(id);
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@RequestBody Employee employee) {
		return edao.save(employee)+ " No of rows saved to the database";
	}
	
	@PutMapping("/employees/{id}")
	public String updateEmployee(@RequestBody Employee employee,@PathVariable int id) {
		return edao.update(employee ,id)+" No of rows updated to database";
		
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		return edao.delete(id)+" No of rows deleted from the database";
	}

}
