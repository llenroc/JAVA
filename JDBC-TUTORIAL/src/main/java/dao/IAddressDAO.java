package dao;

import java.sql.SQLException;
import java.util.List;

import com.example.entity.Address;

public interface IAddressDAO {

	// 1.create
	public void add(Address address) throws SQLException;

	// 2.read
	public List<Address> getAll() throws SQLException;
	public Address getById(Long id) throws SQLException;

	// 3.update
	public void update(Address address) throws SQLException;

	// 4.delete
	public void remove(Address address) throws SQLException;
}
