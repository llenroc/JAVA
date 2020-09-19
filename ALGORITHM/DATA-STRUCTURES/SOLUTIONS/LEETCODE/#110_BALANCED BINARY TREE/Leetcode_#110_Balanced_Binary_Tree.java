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
2020-Sep-19. Oleksii Saiun.
LeetCode_#110. Balanced Binary Tree
https://leetcode.com/problems/balanced-binary-tree/
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root==null)
        {
            return true;
        }
        
        int leftHeight=calcHieght(root.left);
        int rightHeight=calcHieght(root.right);
        int differ = Math.abs(leftHeight-rightHeight);
        if (differ <= 1 && isBalanced(root.left) && isBalanced(root.right))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private int calcHieght(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        
        int leftHeight = calcHieght(root.left);
        int rightHeight = calcHieght(root.right);
        
        if (leftHeight>rightHeight)
        {
            return leftHeight+1;
        }
        else
        {
            return rightHeight+1;
        }
    }
}
