/*
2021-Feb-28. Oleksii Saiun.
LeetCode_#70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/

Time Complexity O(n)
Space Complexity O(n)
Pattern: top-down (memoization)
*/

class Solution {
    public int climbStairs(int n) {
        int[] arr = new int[n+1];
        
        return climbStairs(n,arr);
    }
    
    private int climbStairs(int n, int[] arr) {
        if (n==0 || n==1)
        {
            return 1;
        }
        
        if(arr[n]!=0)
        {
            return arr[n];
        }
        
        arr[n]  = climbStairs(n-1,arr) + climbStairs(n-2,arr);
        return arr[n];
    }
}
