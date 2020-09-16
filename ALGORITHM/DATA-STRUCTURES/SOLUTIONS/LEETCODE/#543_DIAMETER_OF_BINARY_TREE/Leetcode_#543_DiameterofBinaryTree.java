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
2020-Sep-02. Oleksii Saiun.
LeetCode_#543. Diameter of Binary Tree
https://leetcode.com/problems/diameter-of-binary-tree/
*/


class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root==null )
        {
           return 0;
        }
        
        int option1 = calcHeight(root.left) + calcHeight(root.right) ;
        int option2 = diameterOfBinaryTree(root.left);
        int option3 = diameterOfBinaryTree(root.right);
        
        return Math.max(option1, Math.max(option2, option3));
    }
    
    private int calcHeight(TreeNode root)
    {
        if ( root==null )
        {
           return 0;
        }
        
        
        int leftHeight = calcHeight(root.left);
        int rightHeight = calcHeight(root.right);
        
        if( leftHeight > rightHeight )
        {
            return leftHeight+1;
        }
        else
        {
            return rightHeight+1;
        }
    }
}
