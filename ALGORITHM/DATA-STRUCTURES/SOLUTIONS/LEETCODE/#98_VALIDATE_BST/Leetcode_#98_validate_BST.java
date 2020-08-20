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

2020-Aug-20. Oleksii Saiun.
LeetCode_#98.Given a binary tree, determine if it is a valid binary search tree (BST).
https://leetcode.com/problems/validate-binary-search-tree/
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
       return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE );
    }
    
    	private boolean isValidBST(TreeNode root, long min, long max) {

		if (root == null) {
			return true;
		}

         if (!(root.val < max)  || !(root.val > min)) {
			return false;
		}
            
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
    
}
