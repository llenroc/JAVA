/*
2021-Feb-28. Oleksii Saiun.
LeetCode_#509. Fibonacci Number
https://leetcode.com/problems/fibonacci-number/

Time Complexity O(n)
Space Complexity O(n)
Pattern: top-down (memoization)
*/


class Solution {
    public int fib(int n) {
      int[] arr =  new int[n+1];

      return fib(n,arr);
    }
    public int fib(int n, int[] arr) {
        if( n<=0)
        {
            return 0;
        }
        if( n==1)
        {
            return 1;
        }        
        if( arr[n]!=0)
        {
            return arr[n];
        }
        
        arr[n] = fib(n-1,arr) + fib(n-2,arr);
        return arr[n];
    }
}
