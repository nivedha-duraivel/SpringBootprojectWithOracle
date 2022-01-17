package com.talks.service;

import java.sql.SQLException;
import java.util.List;

import com.talks.model.Employee;

public interface IEmployeeService {

	List<Employee> fetchEmployee(String job1, String job2, String job3) throws SQLException;

}
