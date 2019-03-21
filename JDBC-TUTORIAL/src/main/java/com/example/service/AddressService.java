package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.businesslogic.Util;
import com.example.entity.Address;

import dao.IAddressDAO;

/*
 *  [statement] is used for SELECT
 *  [PreparedSatement] is used for dynamic SQL like 
 *  insert into (?,?,?)
 *  or
 *  select *from t1 where ID=?
 * */
public class AddressService extends Util implements IAddressDAO {
	Connection connection = super.getConnection();

	@Override
	public void add(Address address) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO ADDRESS(ID, COUNTRY, CITY, STREET, " + "POST_CODE) VALUES(?,?,?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, address.getId());
			preparedStatement.setString(2, address.getCountry());
			preparedStatement.setString(3, address.getCity());
			preparedStatement.setString(4, address.getStreet());
			preparedStatement.setString(5, address.getPostCode());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();

			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public List<Address> getAll() throws SQLException {
		List<Address> addressList = new ArrayList<>();
		String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Address address = new Address();
				address.setId(resultSet.getLong("ID"));
				address.setCountry(resultSet.getString("COUNTRY"));
				address.setCity(resultSet.getString("CITY"));
				address.setStreet(resultSet.getString("STREET"));
				address.setPostCode(resultSet.getString("POST_CODE"));
				addressList.add(address);
			}

		} catch (SQLException e) {

		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return addressList;
	}

	@Override
	public Address getById(Long id) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "SELECT ID, COUNTRY, CITY, STREET, POST_CODE FROM ADDRESS WHERE ID=?";
		Address address = new Address();
		try {
			preparedStatement = connection.prepareStatement(sql);
			// !!! tricky approach - pay attention
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery(sql);

			address.setId(resultSet.getLong("ID"));
			address.setCountry(resultSet.getString("COUNTRY"));
			address.setCity(resultSet.getString("CITY"));
			address.setStreet(resultSet.getString("STREET"));
			address.setPostCode(resultSet.getString("POST_CODE"));

		} catch (SQLException e) {

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return address;
	}

	@Override
	public void update(Address address) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "UPDATE ADDRESS SET ID=?, COUNTRY=?, CITY=?, STREET=?, POST_CODE=? WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, address.getId());
			preparedStatement.setString(2, address.getCountry());
			preparedStatement.setString(2, address.getCity());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setString(2, address.getPostCode());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	@Override
	public void remove(Address address) throws SQLException {
		PreparedStatement preparedStatement = null;
		String sql = "DELETE FROM ADDRESS  WHERE ID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

}
