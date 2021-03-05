/**
 * @author Oleksii_Saiun. 2021-Mar-04. Staircase. Top-down approach:
 *         memoization
 *         
 * Task: a person can jump to {1}, {2} or {3} steps        
 * Time complexity: O(N)
 * Space complexity: O(N)
 * 
 * input: n=0: number of ways to jump: 1
 * input: n=1: number of ways to jump: 1
 * input: n=2: number of ways to jump: 2
 * input: n=3: number of ways to jump: 4
 * input: n=4: number of ways to jump: 7
 * input: n=5: number of ways to jump: 13
 */
class Calc {
	public static int countStairs(int n) {
		int[] dp = new int[n + 1];

		return countStairs(n, dp);
	}

	public static int countStairs(int n, int[] dp) {
		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		// for three steps you can get by 4 ways. Meanwhile, {4} = as a sum of all
		// previous. Therefore, we don't consider separately case when [n==3]

		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n] = countStairs(n - 3) + countStairs(n - 2) + countStairs(n - 1);
		return dp[n];
	}
}

public class ThreeStairsTopDownApp {
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Number of ways:" + Calc.countStairs(n));

	}

}

class Calc {
	public static int countStairs(int n) {
		int[] dp = new int[n + 1];

		return countStairs(n, dp);
	}

	public static int countStairs(int n, int[] dp) {
		if (n == 0) {
			return 1;
		}

		if (n == 1) {
			return 1;
		}

		if (n == 2) {
			return 2;
		}

		// for three steps you can get by 4 ways. Meanwhile, {4} = as a sum of all
		// previous. Therefore, we don't consider separately case when [n==3]

		if (dp[n] != 0) {
			return dp[n];
		}
		dp[n] = countStairs(n - 3) + countStairs(n - 2) + countStairs(n - 1);
		return dp[n];
	}
}

public class ThreeStairsTopDownApp {
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Number of ways:" + Calc.countStairs(n));

	}

}
