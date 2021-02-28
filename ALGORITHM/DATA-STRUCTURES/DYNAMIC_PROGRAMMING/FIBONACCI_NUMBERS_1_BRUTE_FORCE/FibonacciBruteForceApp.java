/**
 * @author Oleksii_Saiun. 2021-Feb-26. Fibonacci numbers Approach 3. Bottom-Up:
 *         tabulation
 * 
 *         Fibonacci numbers: 0,1,1,2,3,5,8,13,... Fib(7) = 13
 *
 * Time complexity: O(N)
 * Space complexity: O(1)
 */

class Calc {
	public int calcFib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] arr = new int[n + 1];
		int fib = 0;
		int tmpFib_minus_2 = 0; // fib(0)=0;
		int tmpFib_minus_1 = 1;// fib(1)=1;

		for (int j = 2; j <= n; j++) {
			fib = tmpFib_minus_2+ tmpFib_minus_1;
			tmpFib_minus_2 = tmpFib_minus_1;
			tmpFib_minus_1 = fib;
		}
		return fib;
	}

}

public class FibonacciBottomUpApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int n = 7;
		int fib = calc.calcFib(n);
		System.out.println("Fibonacci:" + fib);

	}

}
