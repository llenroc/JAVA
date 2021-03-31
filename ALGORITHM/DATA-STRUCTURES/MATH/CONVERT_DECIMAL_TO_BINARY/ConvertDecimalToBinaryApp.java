/*Oleksii Saiun. 2020-Mar-30. Convert decimal to binary 
 * 
 * Example:
 * input: 50
 * binary: 110010
 * 

 * */


class Calc {
	public String convertDecimalToBinary(int x) {
		StringBuilder str = new StringBuilder();

		while (x > 0) {
			int remainder = x % 2;
			str.append(remainder);
			x = x / 2;
		}
		String strReversed = str.reverse().toString();
		return strReversed;
	}


}

public class ConvertDecimalToBinaryApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int x = 50;
		System.out.println("input: "+x);
		String binaryOfX = Integer.toBinaryString(x);
		System.out.println("In-built method: "+binaryOfX);
		System.out.println("Custom implementation: "+calc.convertDecimalToBinary(x));

	}

}
