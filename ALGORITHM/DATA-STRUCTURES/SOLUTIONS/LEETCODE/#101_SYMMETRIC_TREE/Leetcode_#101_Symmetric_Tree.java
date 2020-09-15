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
LeetCode_#101. Symmetric Tree
https://leetcode.com/problems/symmetric-tree/

watch for explanation
https://www.youtube.com/watch?v=XV7Sg2hJO3Q
*/


class Solution {
    public boolean isSymmetric(TreeNode root) {
		if(root==null)
		{
			return true;
		}
		
		return isSymmetricOfTwoNodes(root.left,root.right);
        
    }
    

    	private boolean isSymmetricOfTwoNodes(TreeNode rootA,TreeNode rootB)
	{
		
		if(rootA==null && rootB==null)
		{
			return true;
		}
		
/*
1) if both nodes not null we compare
    values and recursivle make a call to make sure that
    value from left subtree is equal to value from right subtree
    AND
    value from right subtree is equal to value from left subtree

*/
		if(rootA!=null && rootB!=null)
		{
			return rootA.val==rootB.val && isSymmetricOfTwoNodes(rootA.left, rootB.right) &&  isSymmetricOfTwoNodes(rootA.right, rootB.left);
		}
            else
            {
                return false;
            }
                
	}

}
