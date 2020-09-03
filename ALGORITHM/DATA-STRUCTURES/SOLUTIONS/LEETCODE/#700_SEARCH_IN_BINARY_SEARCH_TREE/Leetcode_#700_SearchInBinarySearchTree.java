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
LeetCode_#700. Search in a Binary Search Tree
https://leetcode.com/problems/search-in-a-binary-search-tree/

input: key=2
		        4
		       / \
		      2   7
		     / \
		    1   3
		    
output:
		      2   
		     / \
		    1   3	
            
*/

class Solution {
	TreeNode rootOut;
    
    public TreeNode searchBST(TreeNode root, int val) {
		inOrder(root, val);
		return rootOut;
	}
    
    	public void inOrder(TreeNode root, int key) {
		if (root == null) {
			return;
		}

		inOrder(root.left, key);
		inOrder(root.right, key);

		if (root.val == key) {
			rootOut = root;
		}		
		return;
	}

    
    
}
