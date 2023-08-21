package ru.mngerasimenko.springboot.dao;

import ru.mngerasimenko.springboot.entity.Employee;

import java.util.List;


public interface EmployeeDAO {

	List<Employee> getAll();

	void save(Employee employee);

	Employee getById(int id);

	void delete(int id);
}
