/*
2021-Apr-26. Oleksii Saiun.
LeetCode_#704. Binary Search. Recursive recursive
https://leetcode.com/problems/binary-search/
*/

class Solution {
    public int search(int[] nums, int target) {
       int startIndex=0;
       int endIndex=nums.length-1;
       return search(nums,target,0, nums.length-1);
    }
    
    private int search(int[] nums, int target, int startIndex, int endIndex) {
        
        if( endIndex<startIndex )
        {
            return -1;
        }

        int middleIndex = startIndex + (endIndex-startIndex)/2;
        
        if(nums[middleIndex]<target)
        {
            startIndex=middleIndex+1;
            return search(nums,target,startIndex,endIndex);
        } else
        if(nums[middleIndex]>target)
        {            
            endIndex=middleIndex-1;
            return search(nums,target,startIndex,endIndex);
        }
        else
            return middleIndex;

    }
}
