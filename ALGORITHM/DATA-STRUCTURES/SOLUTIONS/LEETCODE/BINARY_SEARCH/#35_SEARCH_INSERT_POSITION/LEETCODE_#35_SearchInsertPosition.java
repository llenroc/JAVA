/*
2021-Apr-26. Oleksii Saiun.
LeetCode_#35. Search Insert Position
https://leetcode.com/problems/search-insert-position/
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int startIndex=0;
        int endIndex=nums.length-1;
        
        while(startIndex<endIndex)
        {
            int middleIndex=startIndex+(endIndex-startIndex)/2;
            
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
        /* we consider a coner case, now when startIndex=endIndex and no need to operate with middleIndex
           So, if target>nums[startIndex] then shift +1
           else, put on the place of startIndex
        
        */
        System.out.println("startIndex:"+startIndex+"; endIndex:"+endIndex);
        
        if(target>nums[startIndex])
        {
            return startIndex+1;
        }
        else 
        {
           return startIndex;
        }

    }
}
