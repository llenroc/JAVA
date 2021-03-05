/**
 * @author Oleksii_Saiun. 2021-Mar-04. Staircase. Bottom-up approach:
 *         tabulation
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
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int j = 3; j <= n; j++) {
			dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
		}

		return dp[n];
	}
}

public class ThreeStairsBootomUpApp {
	public static void main(String[] args) {
    int n=5;
    System.out.println("Number of ways:"+Calc.countStairs(n));

	}

}
