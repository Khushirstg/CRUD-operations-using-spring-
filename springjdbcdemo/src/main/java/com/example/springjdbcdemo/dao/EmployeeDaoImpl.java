package com.example.springjdbcdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.springjdbcdemo.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	

	@Override
	public int save(Employee employee) {
		return jdbcTemplate.update("INSERT INTO TBL_EMP(name,email,department) VALUES(?,?,?)" , new Object[] {employee.getName(),employee.getEmail(),employee.getDepartment()});
		
	}

	@Override
	public int update(Employee employee, int id) {
		return jdbcTemplate.update("UPDATE TBL_EMP SET name=?,email=?,department=? WHERE id=?", new Object[] {employee.getName(),employee.getEmail(),employee.getDepartment(),id});
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM TBL_EMP WHERE id=?",id);
		
	}

	@Override
	public List<Employee> getAll() {
	return jdbcTemplate.query("SELECT * FROM TBL_EMP",new BeanPropertyRowMapper<Employee>(Employee.class));
		
	}

	@Override
	public Employee getById(int id) {
	return jdbcTemplate.queryForObject("SELECT * FROM TBL_EMP WHERE ID = ?",new BeanPropertyRowMapper<Employee>(Employee.class),id);
		
	}

}
