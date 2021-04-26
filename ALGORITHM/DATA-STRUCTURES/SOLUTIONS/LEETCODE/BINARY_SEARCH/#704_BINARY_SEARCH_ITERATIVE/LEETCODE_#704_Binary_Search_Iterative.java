/*
2021-Apr-26. Oleksii Saiun.
LeetCode_#704. Binary Search. Iterative appraich
https://leetcode.com/problems/binary-search/
*/

class Solution {
    public int search(int[] nums, int target) {
        int startIndex=0;
        int endIndex=nums.length-1;
        while(startIndex <= endIndex)
        {
            int middleIndex = (startIndex+endIndex)/2;
            if(target<nums[middleIndex])
            {
               endIndex=endIndex-1; 
            } else 
            if(target>nums[middleIndex])
            {
               startIndex=startIndex+1; 
            }
            else
            {
                return middleIndex;
            }
        }
        
        return -1;        
    }
}
