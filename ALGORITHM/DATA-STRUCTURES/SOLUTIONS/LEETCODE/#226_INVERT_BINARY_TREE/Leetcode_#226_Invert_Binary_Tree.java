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
2020-Sep-15. Oleksii Saiun.
LeetCode_#226. Invert Binary Tree
https://leetcode.com/problems/invert-binary-tree/
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
           swapNodes(root);
           return root;
    }
    
    private void swapNodes(TreeNode root) {
        if (root==null)
        {
            return;
        }
        
        swapNodes(root.left);
        swapNodes(root.right);
        
        TreeNode tmpLeft=root.left;
        TreeNode tmpRight=root.right;
        
        root.left=tmpRight;
        root.right=tmpLeft;
    }
}
