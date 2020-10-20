import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestLongestSubstringWithoutRepeatingCharactersApp {

	
	private Calc calc = new Calc();

	@Test
	public void findLength1()
	{
		String str = "aabccbb";
		int out=3;
		assertEquals(calc.findLength(str),out);
	}

	@Test
	public void findLength2()
	{
		String str = "abbbb";
		int out=2;
		assertEquals(calc.findLength(str),out);
	}
	
	@Test
	public void findLength3()
	{
		String str = "abccde";
		int out=3;
		assertEquals(calc.findLength(str),out);
	}
}
