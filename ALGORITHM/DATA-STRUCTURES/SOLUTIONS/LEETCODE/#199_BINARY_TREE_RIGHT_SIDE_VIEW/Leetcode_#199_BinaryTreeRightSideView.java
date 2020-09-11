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
2020-Sep-10. Oleksii Saiun.
LeetCode_#199. Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/
*/

class Solution {
    private LinkedList<LinkedList<Integer>> listAllLevels = new LinkedList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
		List<Integer> listOut = new LinkedList<>();
		  if(root==null)
		  {
			  return listOut;
		  }        
	      
		levelOrderTraversal(root);
		
		for (int j = 0; j < listAllLevels.size(); j++) {
			listOut.add(listAllLevels.get(j).getFirst());
		}

		return listOut;
	}

	public void levelOrderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			int queueSizeOfQueue = queue.size();
			LinkedList<Integer> listLevel = new LinkedList<>();
			for (int j = 0; j < queueSizeOfQueue; j++) {
				TreeNode tmpNode = queue.poll();
				listLevel.addFirst(tmpNode.val);

				if (tmpNode.left != null) {
					queue.offer(tmpNode.left);
				}

				if (tmpNode.right != null) {
					queue.offer(tmpNode.right);
				}
			}
			listAllLevels.add(listLevel);

		}
		System.out.println();
	}

}
