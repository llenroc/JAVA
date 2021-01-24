/*
2021-Jan-24. Oleksii Saiun.
LeetCode_75. Sort Colors
https://leetcode.com/problems/sort-colors/
*/

class Solution {
    public void sortColors(int[] nums) {
        int leftPointer = 0;
        int rightPointer = nums.length-1;
        int i = 0;
      while(i<=rightPointer)
        {
            if(nums[i] == 2)
            {
                swap(nums, i, rightPointer);
                rightPointer--;
            }
            else if(nums[i] == 1)
            {
                i++;
            }
            else if(nums[i] == 0)
            {
                 swap(nums, i, leftPointer);
                 i++;
                 leftPointer++;
            }
        }        
    }
    
    private void swap(int[] nums, int index1, int index2)
    {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
    
    private void displayArray(int[] nums)
    {
        for(int j=0; j<nums.length;j++)
        {
            System.out.print(nums[j]+" ");
        }
        System.out.println();
    }
}
