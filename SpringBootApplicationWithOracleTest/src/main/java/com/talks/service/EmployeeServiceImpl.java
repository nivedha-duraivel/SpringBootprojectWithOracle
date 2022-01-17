package com.talks.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talks.model.Employee;
import com.talks.repo.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	@Override
	public List<Employee> fetchEmployee(String job1, String job2, String job3) throws SQLException {
		
		return employeeRepository.fetchEmployee(job1,job2,job3);
	}

}
