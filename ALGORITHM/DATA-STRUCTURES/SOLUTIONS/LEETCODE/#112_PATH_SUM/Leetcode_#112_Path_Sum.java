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
2020-Aug-31. Oleksii Saiun.
LeetCode_#112.
  Given a binary tree and a sum, determine if the tree has a 
  root-to-leaf path such that adding up all the values along the path equals the given sum.

https://leetcode.com/problems/path-sum/submissions/
*/

class Solution {
    LinkedList<Integer> path = new LinkedList<>();
    boolean statusPathFalse = false;
    
    
    public boolean hasPathSum(TreeNode root, int sum) {
        findPath(root, sum);
        return statusPathFalse;
    }
    
    
    private int sumPath(LinkedList<Integer> path) {
		int outSum = 0;
		for (int j = 0; j < path.size(); j++) {
			outSum = outSum + path.get(j);
		}
		return outSum;
	}
    
    private void findPath(TreeNode root, int sumInput)
    {
        if (root==null)
        {
            return;
        }
        
        path.push(root.val);
        
        if(root.left == null && root.right == null)
        {
            if (sumInput == sumPath(path) )
            {
                statusPathFalse = true;
            }

        }
        
        findPath(root.left, sumInput);
        findPath(root.right, sumInput);

        path.pop();
        return;
    }
    
}
