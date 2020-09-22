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
2020-Sep-21. Oleksii Saiun.
LeetCode_#701. Insert into a Binary Search Tree
https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/
*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null)
        {
            return new TreeNode(val);
        }
        insertValue(root,val);
        return root;
    }
    
    
    public void insertValue(TreeNode root , int key)
	{
		TreeNode tmpNode=root;
		while(1==1)		
		{
			

		if (key < tmpNode.val)
		{

           if(tmpNode.left==null)
           {
        	   tmpNode.left=new TreeNode(key);
        	   return;
           }
           else
           {
        	   tmpNode=tmpNode.left;
           }
		}
		else 
		{
	           if(tmpNode.right==null)
	           {
	        	   tmpNode.right=new TreeNode(key);
	        	   return;
	           }
	           else
	           {
	        	   tmpNode=tmpNode.right;
	           }
		}
		}
		
	}
}
