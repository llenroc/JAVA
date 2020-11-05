/*
2020-Nov-04. Oleksii Saiun.
LeetCode_#912. Sort an Array
https://leetcode.com/problems/sort-an-array/

We use merge sort to sort array
*/   

class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;
    }
    
    private void mergeSort(int[] nums)
    {
        int lengthOfArr=nums.length;
        if (nums.length<=1)
        {
            return;
        }
        
        int mediumPosition = lengthOfArr/2;
        int[] arrLeft = new int[mediumPosition];
        int[] arrRight = new int[lengthOfArr-mediumPosition];
        
        //fill out arrays
        int k=0;
        for(int j=0; j<lengthOfArr; j++)
        {
            if ( j<mediumPosition )
            {
                arrLeft[j] = nums[j];
            }
            else
            {
                arrRight[k++] = nums[j];
            }
        }
        
        mergeSort(arrLeft);
        mergeSort(arrRight);
        
        mergeArrays(nums,arrLeft,arrRight);
    }
    
    private void mergeArrays(int[] nums, int[] arrLeft, int[] arrRight)
    {
        int counterfOfArray=0;
        int counterfOfLeftArray=0;
        int counterfOfRightArray=0;
        
        while(counterfOfLeftArray<arrLeft.length && counterfOfRightArray<arrRight.length)
        {
            if (arrLeft[counterfOfLeftArray]<arrRight[counterfOfRightArray])
            {
                nums[counterfOfArray++] = arrLeft[counterfOfLeftArray++];
            }
            else
            {
                nums[counterfOfArray++] = arrRight[counterfOfRightArray++];
            }                
        }
        
        //fill out a main arrays for remaining values if any
        while(counterfOfLeftArray<arrLeft.length)
        {
                nums[counterfOfArray++] = arrLeft[counterfOfLeftArray++];          
        }    
        
        while(counterfOfRightArray<arrRight.length)
        {
                nums[counterfOfArray++] = arrRight[counterfOfRightArray++];          
        }          
    }
}
