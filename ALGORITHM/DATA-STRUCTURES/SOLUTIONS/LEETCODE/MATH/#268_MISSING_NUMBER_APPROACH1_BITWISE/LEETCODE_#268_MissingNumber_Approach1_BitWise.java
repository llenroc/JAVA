/*
2021-Mar-30. Oleksii Saiun.
LeetCode_#268. Missing Number. Approach1. BitWise
https://leetcode.com/problems/missing-number/

The idea is to do to two sums
A=[0, n+1] - find sum for all range +1;
B=[0, n] -  find sum for cuurent array;

A-B= missing number

If you use traditional "+" it can throw overflow problem for big numbers
To avoid this error we use XOR ("ex zor" - exclusive or)
*/

class Solution {
    public int missingNumber(int[] nums) {
        int sumOfFullArray=0;
        for(int j=0; j<=nums.length; j++)
        {
            sumOfFullArray = sumOfFullArray^j;
        }
        
        int sumOfCurrArray=0;
        for(int j=0; j<nums.length; j++)
        {
            sumOfCurrArray = sumOfCurrArray^nums[j];
        }        
        
        return sumOfFullArray^sumOfCurrArray;
    }
}
