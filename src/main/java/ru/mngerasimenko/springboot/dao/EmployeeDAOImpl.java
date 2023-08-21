package ru.mngerasimenko.employee.rest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.mngerasimenko.employee.rest.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query<Employee> query = session.createQuery("from Employee", Employee.class);

		return query.getResultList();
	}

	@Override
	public void save(Employee employee) {
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(employee);
	}

	@Override
	public Employee getById(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Employee.class, id);
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
		query.setParameter("employeeId", id);

		query.executeUpdate();
	}
}
