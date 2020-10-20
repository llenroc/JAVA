import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFruitsIntoBusketApp {
	private Calc calc = new Calc();
	
	@Test
	public void testFindLength1()
	{
		char[] arr = new char[] { 'A', 'B', 'C', 'A', 'C' };
		int out=3;
		assertEquals(calc.findLength(arr),out);
	}
	
	@Test
	public void testFindLength2()
	{
		char[] arr = new char[] { 'A', 'B', 'C', 'B', 'B', 'C' };
		int out=5;
		assertEquals(calc.findLength(arr),out);
	}
	
	@Test
	public void testFindLength3()
	{
		char[] arr = new char[] { 'A', 'B', 'C', 'A', 'C' };
		int out=3;
		assertEquals(calc.findLength(arr),out);
	}
}
