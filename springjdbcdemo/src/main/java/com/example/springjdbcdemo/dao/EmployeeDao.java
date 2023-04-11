package com.example.springjdbcdemo.dao;

import java.util.List;

import com.example.springjdbcdemo.model.Employee;

public interface EmployeeDao {
	
	int save(Employee employee);
	
	int update(Employee employee,int id);
	
	int delete(int id);
	
	List<Employee> getAll();
	
	Employee getById(int id);
	

}
