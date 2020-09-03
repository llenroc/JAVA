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
2020-Sep-03. Oleksii Saiun.
LeetCode_#938. Range Sum of BST
https://leetcode.com/problems/range-sum-of-bst/
*/

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrder(root, L, R);
        return sumOfNodes;        
    }
    
    Integer sumOfNodes=0;
    
    public void inOrder(TreeNode root, int L, int R)
    {
        if(root==null)
        {
            return;
        }
        
        inOrder(root.left, L, R);
        if( root.val >= L && root.val <= R)
        {
            sumOfNodes = sumOfNodes + root.val;
        }
        inOrder(root.right, L, R);
    }
}
