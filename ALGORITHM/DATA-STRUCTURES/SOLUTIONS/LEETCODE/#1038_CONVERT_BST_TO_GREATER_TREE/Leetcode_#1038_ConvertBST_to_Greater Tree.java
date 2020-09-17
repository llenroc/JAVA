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
2020-Sep-17. Oleksii Saiun.
LeetCode_#1038. Binary Search Tree to Greater Sum Tree
https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
*/

class Solution {
	private int sumTotal;
    
    public TreeNode bstToGst(TreeNode root) {
		sumTotal = calcSumOfTree(root);
		convertBSTtoGreater(root);
		return root;
    }
    

	private void convertBSTtoGreater(TreeNode root) {
		if (root == null) {
			return;
		}

		convertBSTtoGreater(root.left);
		sumTotal = sumTotal - root.val; // incrementally decrease sum
		int tmpSum = sumTotal + root.val;

		root.val=tmpSum;

		convertBSTtoGreater(root.right);
	}


	private int calcSumOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftSide = calcSumOfTree(root.left);
        int rightSide = calcSumOfTree(root.right);
		
		return root.val + leftSide + rightSide;
	}
}
