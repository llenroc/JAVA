/*
2020-Oct-10. Oleksii Saiun.
LeetCode_367. Valid Perfect Square
https://leetcode.com/problems/valid-perfect-square/
*/

class Solution {
	public boolean isPerfectSquare(int n) {        
        if (n==0)
        {
            return false;
        }
        
        if (n==1)
        {
            return true;
        }
        
		return isPerfectSquareLongNumber(n);
	}

	public boolean isPerfectSquareLongNumber(long n) {
		long current_prime = 2;
		long powerOfNumber = 1;
		while (current_prime < n) {

			System.out.println(current_prime);
			powerOfNumber = current_prime;

			while (powerOfNumber < n) {
				powerOfNumber = powerOfNumber * current_prime;
			}

			if (powerOfNumber == n)

			{
				System.out.println("case1");
				return true;
			}

			if (current_prime * current_prime > n) {
				return false;
			}
			current_prime++;
		}

		return false;
	}
}
