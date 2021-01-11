/*
2021-Jan-11. Oleksii Saiun.
LeetCode_#27. Remove Element
https://leetcode.com/problems/remove-element/
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer=0;
        for(int j=0; j<nums.length; j++)
        {
            if(nums[j]!=val)
            {
                nums[pointer++]=nums[j];
            }
   //         displayArray(nums);
        }
            return pointer;
    }   

    public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}
