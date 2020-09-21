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
2020-Sep-21. Oleksii Saiun.
LeetCode_#617. Merge Two Binary Trees
https://leetcode.com/problems/merge-two-binary-trees/
*/

class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null && root2==null)
        {
            return null;
        }
        
        if (root1==null && root2!=null)
        {
            return root2;
        }
        
        if (root1!=null && root2==null)
        {
            return root1;
        }        
        
        TreeNode newNode = new TreeNode(root1.val+root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
        
    }
}
