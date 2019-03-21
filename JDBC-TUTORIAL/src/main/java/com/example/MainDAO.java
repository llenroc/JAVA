package com.example;

import java.sql.SQLException;
import java.util.List;

import com.example.businesslogic.Util;
import com.example.entity.Address;
import com.example.service.AddressService;

public class MainDAO {

	public static void main(String[] args) {
		AddressService addressService = new AddressService();

		Address address = new Address();
		address.setId((long) 2);
		address.setCountry("USA");
		address.setCity("NY");
		address.setStreet("5th Ave");
		address.setPostCode("10005");
		
		try {
			//addressService.add(address);
			
			for(Address adr : addressService.getAll())
			{
			System.out.println(adr.getCity() +"; "+adr.getCountry()+"; "+adr.getCity()+"; "+adr.getCountry()+"; "+adr.getStreet());	
			}
		} catch (SQLException e) {
			// 
			e.printStackTrace();
		}
	}

}
