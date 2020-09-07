class Solution {
/*
2020-Sep-06. Oleksii Saiun.
LeetCode_#342. Power of Four
https://leetcode.com/problems/power-of-four/

*/    
    public boolean isPowerOfFour(int num) {
        
        if (num == 0)
        {
            return false;
        }
        
        if (num == 1)
        {
            return true;
        }
        
        long power = 1;
        
        while( power < num)
        {
            power = 4 * power;
        }
        
        return ( power == num);
        
    }
    
}
