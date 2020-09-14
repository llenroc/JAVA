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
Find the number of paths that sum to a given value.


LeetCode_#437. Path Sum III
https://leetcode.com/problems/path-sum-iii/

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11

*/

class Solution {
private int count=0;
    
public int pathSum(TreeNode root, int keySum) {
		preOrderOuter(root, keySum);
		return count;
	}

	public void preOrderOuter(TreeNode root, int keySum) {
		if (root == null) {
			return;
		}
		preOrder(root, 0, keySum);
		preOrderOuter(root.left, keySum);
		preOrderOuter(root.right, keySum);
	}

	public void preOrder(TreeNode root, int currSum, int keySum) {
		if (root == null) {
			return;
		}

		currSum = currSum + root.val;

		if (currSum == keySum) {
			count = count + 1;
		}

		preOrder(root.left, currSum, keySum);
		preOrder(root.right, currSum, keySum);
	}
}
