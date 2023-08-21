package ru.mngerasimenko.springboot.service;


import ru.mngerasimenko.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {

	List<Employee> getAll();

	void save(Employee employee);

	Employee getById(int id);

	void delete(int id);
}
