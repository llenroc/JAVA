package dao;

import java.util.List;

import com.example.entity.Project;

public interface IProjectDAO {

	// 1.create
	public void add(Project project);

	// 2.read
	public List<Project> getAll();
	public Project getById(Long id);

	// 3.update
	public void update(Project project);

	// 4.delete
	public void remove(Project project);
}
