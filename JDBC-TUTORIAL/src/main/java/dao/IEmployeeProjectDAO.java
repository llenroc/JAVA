package dao;

import java.util.List;

import com.example.entity.Employee;
import com.example.entity.EmployeeProject;

public interface IEmployeeProjectDAO {

	// 1.create
	public void add(EmployeeProject employeeProject);

	// 2.read
	public List<Employee> getAll();
	public Employee getByEmployeeIdAndProjectId(Long employeeId, Long projectId);

	// 3.update
	public void update(EmployeeProject employeeProject);

	// 4.delete
	public void remove(EmployeeProject employeeProject);
}
