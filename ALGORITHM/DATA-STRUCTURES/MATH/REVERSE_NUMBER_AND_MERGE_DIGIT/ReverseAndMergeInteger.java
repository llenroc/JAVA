/*Oleksii Saiun. 2020-Fev-22. Reverse number and merge digit 
 * value:123456
 * reversedValue:654321   
 * 
 * */
class Calc
{
	public static int reverseInteger(int input)
	{
		int reversedValue=0;
		int step=0;
		
		while(input>0)
		{
			int digit=input%10;
			//removing right digit each time			
			input=input/10;			
			reversedValue=reversedValue*10+digit;
			step=10;
		}
			
		return reversedValue;
	}
}
public class ReverseAndMergeInteger {
	public static void main(String[] args) {
    int value=123456;
    int reversedValue=Calc.reverseInteger(value);
    System.out.println("value: "+value);
    System.out.println("reversedValue: "+reversedValue);

	}

}
