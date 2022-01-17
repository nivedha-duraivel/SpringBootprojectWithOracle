package com.talks.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talks.model.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

	@Autowired
	private DataSource ds;
	
	@Override
	public List<Employee> fetchEmployee(String job1, String job2, String job3) throws SQLException {
		
		final String QUERY = "SELECT EMPNO,ENAME,JOB FROM EMP WHERE JOB IN (?,?,?)";
		
		
		
		Connection con = ds.getConnection();
		
		PreparedStatement ps = con.prepareStatement(QUERY);
		
		ps.setString(1, job1);
		ps.setString(2, job2);
		ps.setString(3, job3);
		
		ResultSet rs = ps.executeQuery();
		
		List<Employee> listemp = new ArrayList<>();
		
		while(rs.next())
		{
			Employee emp = new Employee();
			emp.setEmpNo(rs.getInt(1));
			emp.setEmpName(rs.getString(2));
			emp.setJob(rs.getString(3));
			listemp.add(emp);
		}
				
		return listemp;
	}
	
	

}
