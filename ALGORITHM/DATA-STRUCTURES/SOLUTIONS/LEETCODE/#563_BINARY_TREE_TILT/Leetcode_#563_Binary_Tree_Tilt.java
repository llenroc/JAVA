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
2020-Sep-15. Oleksii Saiun.
LeetCode_#563. Binary Tree Tilt
https://leetcode.com/problems/binary-tree-tilt/
*/


class Solution {
	private int totalOfTilts=0;
    public int findTilt(TreeNode root) {
 
        postOrder(root);
        return totalOfTilts;
    }
    
    private int postOrder(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        
        int sumOfleftSide=postOrder(root.left);
        int sumOfrightSide=postOrder(root.right);
        
        int tilt=0;
        if (root.left!=null && root.right!=null)
        {
            tilt=Math.abs(sumOfleftSide - sumOfrightSide);
        }
         else if (root.left!=null && root.right==null)
         {
             tilt=Math.abs(sumOfleftSide);
         }
        else if (root.left==null && root.right!=null)
         {
             tilt=Math.abs(sumOfrightSide);
         }

        totalOfTilts = totalOfTilts + tilt;

        return root.val + sumOfleftSide + sumOfrightSide;
        
    }
}
