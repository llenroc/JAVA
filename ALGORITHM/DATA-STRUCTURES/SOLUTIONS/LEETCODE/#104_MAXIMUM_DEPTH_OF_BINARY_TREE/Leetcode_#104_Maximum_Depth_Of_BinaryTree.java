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
LeetCode_#104.
  Given a binary tree, find its maximum depth.
https://leetcode.com/problems/maximum-depth-of-binary-tree/
*/


class Solution {
    public int maxDepth(TreeNode root) {
        
        if (root==null)
        {
            return 0;
        }
        
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        
        return Math.max(leftDepth,rightDepth)+1;
    }
}
