/*
2021-Apr-28. Oleksii Saiun.
34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {        
        int searchedIndex = binarySearch(nums,target);
        
        /*
        we find an index of target element in array.After that we expanding a range
        */
        if (searchedIndex!=-1)
        {
            int leftIndex=searchedIndex;
            int rightIndex=searchedIndex;
            while(leftIndex>0 && nums[leftIndex-1]==target)
            {
                --leftIndex;
            }
            
            while(rightIndex<=nums.length-2 && nums[rightIndex+1]==target)
            {
                ++rightIndex;
            }    
                    return new int[]{leftIndex,rightIndex};
        }
        return new int[]{-1,-1};
    }
    
    private int binarySearch(int[] nums, int target)
    {
        int startIndex=0;
        int endIndex=nums.length-1;
        
        while(startIndex<=endIndex)
        {
            int middleIndex = startIndex + (endIndex-startIndex)/2;
            
            if(target>nums[middleIndex])
            {
                startIndex=middleIndex+1;
            }
            else if(target<nums[middleIndex])
            {
                endIndex=middleIndex-1;
            }      
            else
            {
                return middleIndex;
            }
        }
        
        return -1;
    }
}
