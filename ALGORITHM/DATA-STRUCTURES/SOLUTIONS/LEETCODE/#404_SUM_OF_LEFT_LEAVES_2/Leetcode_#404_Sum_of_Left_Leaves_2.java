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
2020-Oct-12. Oleksii Saiun.
LeetCode_#404. Sum of Left Leaves
https://leetcode.com/problems/sum-of-left-leaves/
*/

class Solution {
    private int index=0;
    private int sum=0;
    public int sumOfLeftLeaves(TreeNode root) {
        inOrder(root,0);
        return sum;
    }
    
    private void inOrder(TreeNode root, int index)
    {
        if (root==null)
        {
            return;
        }
        
        inOrder(root.left,index-1);
        inOrder(root.right,0);
        
        if(root.left == null & root.right == null && index<0)
        {
            sum = sum + root.val;
            System.out.println(root.val);
        }
        
    }
}
