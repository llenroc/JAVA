/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
2020-Aug-31. Oleksii Saiun.
LeetCode_#108.
    Convert Sorted Array to Binary Search Tree   
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
*/

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }
    
    public TreeNode sortedArrayToBST(int[] arr, int startIndex, int endIndex)
    {
        if(startIndex > endIndex)
        {
            return null;
        }
        
        int midIndex = (startIndex + endIndex)/2;
        TreeNode root = new TreeNode(arr[midIndex]);
        
        root.left = sortedArrayToBST(arr, startIndex, midIndex-1);
        root.right = sortedArrayToBST(arr, midIndex+1, endIndex);
        return root;
    }
}
