package com.talks.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.talks.model.Employee;
import com.talks.service.IEmployeeService;

//Controller
@Controller
public class EmployeeController {
	
	@Autowired
	private IEmployeeService employeeService;
	
	public List<Employee> fetchEmployee(String job1,String job2,String job3) throws SQLException
	{
		return employeeService.fetchEmployee(job1,job2,job3);
	}

}
