/*
2021-Feb-28. Oleksii Saiun.
LeetCode_#509. Fibonacci Number
https://leetcode.com/problems/fibonacci-number/

Time Complexity O(n)
Space Complexity O(n)
Pattern: bottom-up (tabulation)
*/

class Solution {
    public int fib(int n) {
        if (n==0)
        {
            return 0;
        }
        
        if (n==1)
        {
            return 1;
        }        
        
        int fibMinus2=0;
        int fibMinus1=1;
        int fib=0;
        for(int j=2; j<=n; j++)
        {
            fib = fibMinus2 + fibMinus1;
            fibMinus2=fibMinus1;
            fibMinus1=fib;
        }
        
    return fib;
    }
}
