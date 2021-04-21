/*

2021-Apr-21. Regular expression. Password Validity

1. It must have a capital letter.
2. It must contain at least one number.
3. It must contain a punctuation mark or mathematical symbol.
4. It cannot have the word "password" in the string.
5. It must be longer than 7 characters and shorter than 31 characters.

Example:

input = "passWord123!!!!";
output = false;
		
input = "turkey90AAA=";
output = true;

 */

class Calc {
	public boolean isValidPassword(String str) {

		String patternUpperCaseChars = "(.*[A-Z].*)";
		String patternNumbers = "(.*[0-9].*)";
		String patternSpecialChars = "(.*[@,#,$,%,=,-,+,*,/].*$)";
		String patternExceptWord = "password";

		// [1]. It must have a capital letter
		if (!str.matches(patternUpperCaseChars)) {
			return false;
		}
		// [2]. It must contain at least one number.
		if (!str.matches(patternNumbers)) {
			return false;
		}
		// [3]. It must contain a punctuation mark or mathematical symbol.
		if (!str.matches(patternSpecialChars)) {
			return false;
		}

		// [4]. It cannot have the word "password" in the string.
		if (str.toLowerCase().contains(patternExceptWord)) {
			return false;
		}

		// [5]. It must be longer than 7 characters and shorter than 31 characters.
		if (str.length() <= 7 || str.length() > 31) {
			return false;
		}
		return true;
	}
}

public class PasswordValidityApp {
	public static void main(String[] args) {
		Calc calc = new Calc();	
		// String str = "passWord123!!!!";
		String str = "turkey90AAA=";

		System.out.println(calc.isValidPassword(str));
	}

}
