/*Oleksii Saiun. 2020-Sep-26. Count all unique BST
 * https://leetcode.com/problems/unique-binary-search-trees/submissions/
 * 
 * THis problem is known as Catalan number. It can be solved by formula.
 * 
 *           [n-1]
 *  C(n)= SUM      C(i)*C(n-i-1);
 *           [i=0]
 * 
 * 
 * we use array in order to store previously calculated Catalan numbers and not repeat calculations
 * */
class Calc {
//---
	public int[] calcCatalan(int n) {

		if (n == 0 || n == 1) {
			return new int[1];
		} else {
			int[] arr = new int[n+1];
			arr[0]=1;
			
			
           for(int k=1; k<=n;k++)
           {
        	   
        	   int sum = 0;
        	   for(int i=0;i<k;i++)
        	   {
        		   sum = sum + arr[i]*arr[k-i-1];
        	   }
        	   arr[k]=sum;
           }
		return arr;
		}
	}
//----	
}

public class CatalanNumberApp2 {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] catalan=calc.calcCatalan(10);
		for(int j=0; j<catalan.length;j++)
		{
			System.out.println("Catalan("+j+") = "+catalan[j]);
		}

	}

}
