import static org.junit.Assert.*;

import org.junit.Test;

public class Test_PasswordValidityApp {
	private Calc calc = new Calc();

	@Test
	public void test_isValidPassword1() {
		String input = "passWord123!!!!";
		Boolean out = false;
		assertEquals(calc.isValidPassword(input), out);
	}
	
	@Test
	public void test_isValidPassword2() {
		String input = "turkey90AAA=";
		Boolean out = true;
		assertEquals(calc.isValidPassword(input), out);
	}	
}
