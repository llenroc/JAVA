/*
2020-Sep-07. Oleksii Saiun. Convert integer to array of integers
*/
class Calc
{
	public int[] convertIntToArray(int n)
	{
		int size = String.valueOf(n).length();
		int[] arr = new int[size];
		
		for (int j=0;j<size;j++)
		{
			int lastDigit = n%10;
			arr[j]=lastDigit;
			n = n/10; //get next digit = we decrease int value by 1 digit from the right side			
		}
		
		return arr;
	}
}
public class ConvertIntToArrayOfIntegersApp {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr = calc.convertIntToArray(123456);
		
		for(int j=arr.length-1; j>=0; j--)
		{
			System.out.println(arr[j]);
		}

	}

}
