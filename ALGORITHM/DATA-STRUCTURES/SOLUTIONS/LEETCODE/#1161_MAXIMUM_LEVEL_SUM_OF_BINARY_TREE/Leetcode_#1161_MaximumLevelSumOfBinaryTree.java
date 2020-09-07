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
2020-Sep-06. Oleksii Saiun.
LeetCode_#1161. Maximum Level Sum of a Binary Tree
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
*/
class Solution {
    private Map<Integer, Integer> treeMap = new TreeMap<>();
    public int maxLevelSum(TreeNode root) {
        levelOrderTraversal(root);
		int lastElement = getLastElementFromMap();
		return lastElement;
    }
    	
	private int getLastElementFromMap() {
		int index = 0;
		int outValue = 0;
		for (Map.Entry<Integer, Integer> mapTable : treeMap.entrySet()) {
			// we need only the last element and I could not find how get the last element from
			// map THerefore I use for loop
			if (index == treeMap.size()-1) {
				outValue = mapTable.getValue();
				break;
			}
         index=index+1;
		}
		return outValue;
	}

	private void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		int height = 1;

		TreeNode dummyNode = new TreeNode(Integer.MIN_VALUE);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(dummyNode);
		int sum = 0;
		while (!queue.isEmpty()) {
			TreeNode tmpNode = queue.poll();

			if (tmpNode.val == dummyNode.val) {
				// System.out.println(sum);
				// we use [sum] as a key, because we want to take the highest sum and output its
				// level
				// [TreeMap<>()] allows to store data by sorted ascending order. So, the highest (the last element)
				// sum is our outcome
				treeMap.put(sum, height);
				// reset sum when jump to a new level
				sum = 0;
				height = height + 1;
				if (!queue.isEmpty()) {
					queue.offer(dummyNode);
				}
			} else {

				sum = sum + tmpNode.val;
				// tmpNode.displayValue();

			}

			if (tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}
			if (tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}

		}

	}
}
