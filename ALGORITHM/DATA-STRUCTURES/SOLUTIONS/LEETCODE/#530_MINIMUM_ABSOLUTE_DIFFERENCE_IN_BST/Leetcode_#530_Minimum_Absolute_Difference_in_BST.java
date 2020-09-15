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
2020-Sep-14. Oleksii Saiun.
LeetCode_#530. Minimum Absolute Difference in BST
https://leetcode.com/problems/minimum-absolute-difference-in-bst/
*/


class Solution {
    private LinkedList<Integer> list = new LinkedList<>();
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
			return 0;
		}

		inOrder(root);
		
		int minDist = Integer.MAX_VALUE;
		for (int j = 0; j < list.size()-1; j++) {
			int currentMin = list.get(j+1) - list.get(j);
			minDist = Math.min(minDist, currentMin);
		}

		return minDist;
    }
    
    private void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}
}
