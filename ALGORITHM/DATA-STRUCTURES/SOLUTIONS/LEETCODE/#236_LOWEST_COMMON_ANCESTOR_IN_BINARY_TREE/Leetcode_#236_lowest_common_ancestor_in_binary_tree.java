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
2020-Aug-23. Oleksii Saiun.
LeetCode_#236. Lowest Common Ancestor of a Binary Tree
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null)
		{
			return null;
		}
		
		if(root.val == p.val || root.val == q.val)
		{
			return root;
		}
		
		
        TreeNode leftTreeNode = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTreeNode = lowestCommonAncestor(root.right,p,q);
		
        if(leftTreeNode!=null && rightTreeNode!=null)
        {
        	return root;
        }
        else if (leftTreeNode!=null && rightTreeNode==null)
        {
        	return leftTreeNode;
        }
        else if (rightTreeNode!=null && leftTreeNode==null)
        {
        	return rightTreeNode;
        }
        else
        {
        	return null;
        }
    }
}
