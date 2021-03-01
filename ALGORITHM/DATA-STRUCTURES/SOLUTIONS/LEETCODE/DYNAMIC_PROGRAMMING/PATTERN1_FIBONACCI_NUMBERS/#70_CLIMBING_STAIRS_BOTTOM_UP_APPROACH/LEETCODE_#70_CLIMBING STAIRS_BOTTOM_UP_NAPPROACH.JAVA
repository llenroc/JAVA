/*
2021-Feb-28. Oleksii Saiun.
LeetCode_#70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

Time Complexity O(n)
Space Complexity O(1)
Pattern: bottom-up (tabulation)
*/


class Solution {
    public int climbStairs(int n) {
        if (n==0)
        {
            return 0;
        }
        
        if (n==1)
        {
            return 1;
        }        
        
    
        int climbPrev2=1;
        int climbPrev1=1;
        int sum=0;
        
        for(int j=2; j<=n; j++)
        {
            sum = climbPrev2 + climbPrev1;
            climbPrev2=climbPrev1;
            climbPrev1=sum;
        }
        
        return sum;
    }
}
