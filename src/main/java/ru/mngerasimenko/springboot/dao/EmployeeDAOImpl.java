package ru.mngerasimenko.springboot.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mngerasimenko.springboot.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private final EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getAll() {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		return query.getResultList();
	}

	@Override
	public void save(Employee employee) {
		Session session = entityManager.unwrap(Session.class);

		session.saveOrUpdate(employee);
	}

	@Override
	public Employee getById(int id) {
		Session session = entityManager.unwrap(Session.class);

		return session.get(Employee.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);

		query.executeUpdate();
	}
}
