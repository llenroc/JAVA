package dao;

import java.util.List;

import com.example.entity.Employee;

public interface IEmployeeDAO {

	// 1.create
	public void add(Employee employee);

	// 2.read
	public List<Employee> getAll();
	public Employee getById(Long id);

	// 3.update
	public void update(Employee employee);

	// 4.delete
	public void remove(Employee employee);
}
