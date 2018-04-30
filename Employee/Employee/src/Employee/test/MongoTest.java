package com.employee.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.employee.domain.Employee;
import com.employee.repository.EmployeeRepositoryImpl;
import com.employee.repository.Repository;

public class MongoTest {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/spring/applicationContext.xml");

		Repository repository = context.getBean(EmployeeRepositoryImpl.class);

		// cleanup collection before insertion
		repository.dropCollection();

		// create collection
		repository.createCollection();

		repository.saveEmployee(new Employee("1", "Janni"));

		System.out.println("1. " + repository.getAllEmployee());

		repository.saveEmployee(new Employee("2", "Daniel", 3));

		System.out.println("2. " + repository.getAllEmployee());

		System.out.println("Employee with id 1" + repository.getEmployee("1"));

		repository.updateEmployee("1", "Danie");

		System.out.println("3. " + repository.getAllEmployee());

		repository.deleteEmployee("2");

		System.out.println("4. " + repository.getAllEmployee());
	}
}
