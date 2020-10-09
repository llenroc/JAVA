package math.catalan_number1;

/*Oleksii Saiun. 2020-Sep-26. Count all unique BST
 * https://leetcode.com/problems/unique-binary-search-trees/submissions/
 * 
 * This problem is known as Catalan number. It can be solved by formula.
 * 
 *           [n-1]
 *  C(n)= SUM      C(i)*C(n-i-1);
 *           [i=0]
 * 
 * 
 * It is brute force solution. We repeat calculations for previous Catalan numbers
 * */

class Calc
{	
	public int catalan(int n)
	{
		int sum=0;
		if (n==0)
		{
			return 1;
		}
		for (int j=0;j<=n-1;j++)
		{
			sum= sum + catalan(j)*catalan(n-j-1);
		}
		
		return sum;
	}
}
public class CatalanNumberApp1 {

	public static void main(String[] args) {
      Calc calc = new Calc();
      System.out.println(calc.catalan(4));
      

	}

}


/*

                      1
                     /  \
                    2    9
                  /	  \   \
                 3     4   10
                        \   \
                         5   11
                          \    \
                           6    12
                          /  \    \
                         7    8    13
                                  /  \
                                 14   15
                                  \
                                   16

*/

