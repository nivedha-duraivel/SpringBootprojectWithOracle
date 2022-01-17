package com.talks;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.talks.controller.EmployeeController;
import com.talks.model.Employee;

@SpringBootApplication
public class SpringBootApplicationWithOracleTestApplication {

	public static void main(String[] args) {
	ApplicationContext context = SpringApplication.run(SpringBootApplicationWithOracleTestApplication.class, args);
	
	EmployeeController controller =  context.getBean("employeeController",EmployeeController.class);
	
	try {
		List<Employee> listemp =  controller.fetchEmployee("PRESIDENT", "CLERK", "ANALYST");
		
		listemp.forEach(System.out::println);

		
	} catch (SQLException e) {
		System.out.println("Employee Exception");
		e.printStackTrace();
	}
	
	}

}
