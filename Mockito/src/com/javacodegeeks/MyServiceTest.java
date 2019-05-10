package com.javacodegeeks;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class MyServiceTest {

	@Mock
	private MyDao myDao;

	@Rule
	public MockitoRule rule = MockitoJUnit.rule();

	@Test
	public void test() {
		MyEntity testEntity1 = new MyEntity();
		testEntity1.setFirstName("My first name");
		testEntity1.setSurname("My surname");

		MyService myService = new MyService(myDao);
		Mockito.when(myDao.findById(1L)).thenReturn(testEntity1);

		MyEntity actual = myService.findById(1L);
		Assert.assertEquals(testEntity1.getFirstName(), actual.getFirstName());
		Assert.assertEquals(testEntity1.getSurname(), actual.getSurname());
		Mockito.verify(myDao).findById(1L);
	}

}