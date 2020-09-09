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
2020-Sep-08. Oleksii Saiun.
LeetCode_#543. Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
*/

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root==null)
        {
            return 0;
        }

        int diameterViaRoot = calcHeight(root.left) + calcHeight(root.right);
        int diameterNotViaRoot = Math.max(calcHeight(root.left), calcHeight(root.right));
        int diameter = Math.max(diameterViaRoot,diameterNotViaRoot);  
        return diameter;
    }
    
    
        public int calcHeight(TreeNode root) {
        
        if (root==null)
        {
            return 0;
        }
        
        int leftDepth = calcHeight(root.left);
        int rightDepth = calcHeight(root.right);
        
       if ()
       {
           
       }
    }
}
