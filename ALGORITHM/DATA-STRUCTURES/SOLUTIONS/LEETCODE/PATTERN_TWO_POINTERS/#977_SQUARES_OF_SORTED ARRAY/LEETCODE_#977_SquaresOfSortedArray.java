/*
2021-Jan-12. Oleksii Saiun.
LeetCode_#977. Squares of a Sorted Array
https://leetcode.com/problems/squares-of-a-sorted-array/
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] out = new int[nums.length];
        int indexOut=nums.length-1;
        
        int leftPointer=0;
        int rightPointer=nums.length-1;
            
            while(leftPointer <= rightPointer)
            {
                int leftSquare = nums[leftPointer]*nums[leftPointer];
                int rightSquare = nums[rightPointer]*nums[rightPointer];
                
                if(leftSquare<rightSquare)
                {
                    out[indexOut] = rightSquare;
                    indexOut--;
                    rightPointer--;
                }
                else 
                {
                    out[indexOut] = leftSquare;
                    indexOut--;
                    leftPointer++;                    
                }
            }        
        return out;                
    }

}
