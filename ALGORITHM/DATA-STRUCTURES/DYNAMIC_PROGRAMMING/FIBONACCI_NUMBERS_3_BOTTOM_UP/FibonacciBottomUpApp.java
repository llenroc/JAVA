package dynamic_programming.fibonacci.top_down;

/**
 * @author Oleksii_Saiun. 2021-Feb-26. Fibonacci numbers Approach 2. Top-down:
 *         memoization
 * 
 *         Fibonacci numbers: 0,1,1,2,3,5,8,13,... Fib(7) = 13
 *
 * Time complexity: O(N)
 * Space complexity: O(N)
 */

class Calc {
	public int calcFib(int n) {
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		return calcFib(n, arr);
	}

	private int calcFib(int n, int[] arr) {
		/**
		 * we can initially store data for n==0 or n==1 in array, but it is a quite
		 * difficult to handle initial case when n==0 or n==1, because it is a "default
		 * values" Therefore we will not store it in array and return values immediately
		 * if n==0 or n==1
		 */
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		// be default array has a value [0], therefore we check if it not 0 we take
		// already calc value from array, otherwise, we calculate it firstly
		if (arr[n] != 0) {
			return arr[n];
		}

		arr[n] = calcFib(n - 1, arr) + calcFib(n - 2, arr);

		return arr[n];
	}
}

public class FibonacciTopDownApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int n = 8;
		int fib = calc.calcFib(n);
		System.out.println("Fibonacci:" + fib);

	}

}
