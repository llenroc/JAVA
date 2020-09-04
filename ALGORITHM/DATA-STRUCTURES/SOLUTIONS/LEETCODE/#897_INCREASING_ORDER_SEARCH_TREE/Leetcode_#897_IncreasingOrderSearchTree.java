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
LeetCode_#897. Increasing Order Search Tree
https://leetcode.com/problems/increasing-order-search-tree/
*/

class Solution {
	private LinkedList<TreeNode> list = new LinkedList<>();

    	public TreeNode increasingBST(TreeNode root) {
		if (root == null) {
			return null;
		}

		inOrder(root);
		return buildBinaryTree();
	}

	private void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root);
		inOrder(root.right);
	}

	private TreeNode buildBinaryTree() {
		TreeNode rootResult = new TreeNode(list.removeFirst().val);
		TreeNode rootTmp = rootResult;
		while (!list.isEmpty()) {
			rootTmp.right = new TreeNode(list.removeFirst().val);
			//the trickiest part!!!
			rootTmp = rootTmp.right;
		}

		return rootResult;
	}
    
}
