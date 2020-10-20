import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class TestLongestSubstringwithDistinctCharactersApp {
	private Calc calc = new Calc();

	@Test
	public void findLength1() {
		String str = "araaci";
		int k = 2;
		int out=4;
		assertEquals(calc.findLength(str, k),out);
	}

	@Test
	public void findLength2() {
		String str = "araaci";
		int k = 1;
		int out=2;
		assertEquals(calc.findLength(str, k),out);
	}
	
	@Test
	public void findLength3() {
		String str = "cbbebi";
		int k = 3;
		int out=5;
		assertEquals(calc.findLength(str, k),out);
	}
}
