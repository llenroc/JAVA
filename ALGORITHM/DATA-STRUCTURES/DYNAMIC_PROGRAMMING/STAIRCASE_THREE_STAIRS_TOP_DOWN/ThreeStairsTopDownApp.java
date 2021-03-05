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
