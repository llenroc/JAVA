/*
2021-Feb-26. Oleksii Saiun.
LeetCode_#1137. N-th Tribonacci Number
https://leetcode.com/problems/n-th-tribonacci-number/
Time Complexity O(n)
Space Complexity O(n)
Pattern: fibonacci
*/

class Solution {
    public int tribonacci(int n) {
        int[] arr= new int[n+1];
    return tribonacci(n,arr);
    }
    
    private int tribonacci(int n,int[] arr)
    {
        if(n==0)
        {
            return 0;
        }
        
        if(n==1 || n==2)
        {
            return 1;
        }        
        
        if(arr[n]!=0)
        {
            return arr[n];
        }
        
           arr[n] = tribonacci(n-3,arr) + tribonacci(n-2,arr) + tribonacci(n-1,arr);
        
        return arr[n];                
    }
}
