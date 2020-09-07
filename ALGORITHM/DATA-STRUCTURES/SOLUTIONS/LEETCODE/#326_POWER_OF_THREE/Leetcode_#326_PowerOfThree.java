class Solution {
    
/*
2020-Sep-06. Oleksii Saiun.
LeetCode_#231. Power of Three
https://leetcode.com/problems/power-of-three/
*/
    
    public boolean isPowerOfThree(int n) {
        if (n==0)
        {
            return false;
        }
        
        if (n==1)
        {
            return true;
        }
        
        long power = 1;
        
        while( power < n)
        {
            power = power * 3;
        }
        
        return (power == n);
    }
}
