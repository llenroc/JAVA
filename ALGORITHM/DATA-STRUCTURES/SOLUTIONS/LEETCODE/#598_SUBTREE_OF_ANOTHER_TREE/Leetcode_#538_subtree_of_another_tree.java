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
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        if(s==null )
		{
			return false;
		}
		
		
		if (isSame(s,t))
		{
			return true;
		}
		else
		{
		 return	isSubtree(s.left,t) || isSubtree(s.right,t);
		}
    }
    
    	private boolean isSame(TreeNode rootA, TreeNode rootB)
	{
		if(rootA==null && rootB==null)
		{
			return true;
		}
		
		if(rootA==null|| rootB==null)
		{
			return false;
		}
		
		if(rootA.val==rootB.val && isSame(rootA.left,rootB.left) && isSame(rootA.right,rootB.right))
		{
			return true;
		}
		return false;
	}
}
