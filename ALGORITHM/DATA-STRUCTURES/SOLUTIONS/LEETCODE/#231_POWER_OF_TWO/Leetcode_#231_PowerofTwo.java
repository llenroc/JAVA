class Solution {


/*
2020-Sep-06. Oleksii Saiun.
LeetCode_#231. Power of Two
https://leetcode.com/problems/power-of-two/

*/
    
    
    /* //It is my approach. It works, but it has unnecesary check for each iteration inside a loop
	public boolean isPowerOfTwo(int n) {
		boolean isPrime = false;
		if (n == 0) {
			return false;
		}

		if (n == 1) {
			return true;
		}

		long power = 1;
		while (power <= n) {
			power = power * 2;
			if (power == n) {
				isPrime = true;
				break;
			}
		}
		return isPrime;
	}
    */
    
    public boolean isPowerOfTwo(int n)
    {
        if(n==0)
        {
            return false;
        }
                
        if(n==1)
        {
            return true;
        }
        
        long power=1;
        
        while(power < n)
        {
            power = power*2;
        }
        
        return (power == n);
    }
}
