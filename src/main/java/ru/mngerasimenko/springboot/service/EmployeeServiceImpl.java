package ru.mngerasimenko.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mngerasimenko.springboot.dao.EmployeeDAO;
import ru.mngerasimenko.springboot.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> getAll() {
		return employeeDAO.getAll();
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		employeeDAO.save(employee);
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		return employeeDAO.getById(id);
	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDAO.delete(id);
	}
}
