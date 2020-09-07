/*
2020-Sep-07. Oleksii Saiun. Conversion from Binary number to Decimal 
      The formula is used:
      for example, input = [11101]
      = 1*(2^4) + 1*(2^3) + 1*(2^2) + 1*(2^1) + 0*(2^0)
      
      Binary number:is base-2 numeral system or binary numeral system. This system uses only two symbols: 
      typically 1 (one) and 0 (zero).
      
      Decimal number: The decimal numeral system is the standard system for denoting integer and non-integer numbers. 
      It is also called base-ten positional numeral system.
*/

class Calc {
	public int calcPowerOfTwo(int n) {
		if (n == 0) {
			return 1;
		}
		
		return 2*calcPowerOfTwo(n-1);
	}
	
	public int[]  parseIntToArray(int n)
	{
		String str =  String.valueOf(n);
        int[] arr = new int[str.length()];
        
        for(int j=0;j<arr.length;j++)
         {
        	int lastDigit = n%10; // get last digit
        	arr[j]=lastDigit;
            n=n/10; //divide by 10 to get next digit

        }
        return arr;
	}
	
	public int  convertIntToDecimal(int n)
	{
		int arr[] = parseIntToArray(n);
		int sum=0;
		
		for(int j=0;j<arr.length;j++)
		{
			sum=sum+arr[j]*calcPowerOfTwo(j);
		}
		return sum;
	}
	
	
}

public class ConvertBinaryToDecimalApp {

	public static void main(String[] args) {
		Calc calc = new Calc();	
		System.out.println(calc.convertIntToDecimal(11101 ));
	}

}
