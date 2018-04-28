package com.employee.repository;

import java.util.List;

import com.mongodb.WriteResult;
import com.employee.domain.Employee;

public interface Repository {

	public List<Employee> getAllEmployee();

	public void saveEmployee(Employee employee);

	public Employee getEmployee(String id);

	public WriteResult updateEmployee(String id, String name);

	public void deleteEmployee(String id);

	public void createCollection();

	public void dropCollection();
}
