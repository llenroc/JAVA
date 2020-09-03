/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
2020-Sep-02. Oleksii Saiun.
LeetCode_#235. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
        {
            return null;
        }
        
        if (root.val == p.val)
        {
            return root;
        }
        
        if (root.val == q.val)
        {
            return root;
        }
        
        TreeNode leftRoot = lowestCommonAncestor(root.left, p, q);
        TreeNode rightRoot = lowestCommonAncestor(root.right, p, q);
        
        if (leftRoot !=null  && rightRoot !=null)
        {
            return root;
        }
        else if (leftRoot!=null && rightRoot==null)
        {
            return leftRoot;
        }
        else if (leftRoot==null && rightRoot!=null)
        {
            return rightRoot;
        }           
        else
        {
            return null;
        }
    }
}
