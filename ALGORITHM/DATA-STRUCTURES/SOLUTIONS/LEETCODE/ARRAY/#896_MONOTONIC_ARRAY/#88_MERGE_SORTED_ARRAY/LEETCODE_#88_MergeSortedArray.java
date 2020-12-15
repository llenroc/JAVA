/*
2020-Dec-15. Oleksii Saiun.
LeetCode_#88. Merge Sorted Array
https://leetcode.com/problems/merge-sorted-array
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i0=m+n-1;  //pointer to the first array for inserting values
        int i1=m-1; //pointer to the first array
        int i2=n-1;  //pointer to the second array
        
        while(i1>=0 && i2>=0)
        {
            if(nums1[i1] > nums2[i2])
            {
                nums1[i0--]=nums1[i1--];
            }
            else
            {
                nums1[i0--]=nums2[i2--];
            }
        }
        
        while(i2>=0)
        {
             nums1[i0--]=nums2[i2--];
        }
    }
}
