package com.employee.repository;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;
import com.employee.domain.Employee;

public class EmployeeRepositoryImpl implements Repository {

	MongoTemplate mongoTemplate;

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * Get all Employee.
	 */
	public List<Employee> getAllEmployee() {
		return mongoTemplate.findAll(Employee.class);
	}

	/**
	 * Saves a {@link Employee}.
	 */
	public void saveEmployee(Employee employee) {
		mongoTemplate.insert(employee);
	}

	/**
	 * Gets a {@link Employee} for a particular id.
	 */
	public Tree getEmployee(String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("id").is(id)),
				Employee.class);
	}

	/**
	 * Updates a {@link Employee} name for a particular id.
	 */
	public WriteResult updateTree(String id, String name) {
		return mongoTemplate.updateFirst(
				new Query(Criteria.where("id").is(id)),
				Update.update("name", name), Employee.class);
	}

	/**
	 * Delete a {@link Employee} for a particular id.
	 */
	public void deleteEmployee(String id) {
		mongoTemplate
				.remove(new Query(Criteria.where("id").is(id)), Employee.class);
	}

	/**
	 * Create a {@link Employee} collection if the collection does not already
	 * exists
	 */
	public void createCollection() {
		if (!mongoTemplate.collectionExists(Employee.class)) {
			mongoTemplate.createCollection(Employee.class);
		}
	}

	/**
	 * Drops the {@link Employee} collection if the collection does already exists
	 */
	public void dropCollection() {
		if (mongoTemplate.collectionExists(Employee.class)) {
			mongoTemplate.dropCollection(Employee.class);
		}
	}
}
