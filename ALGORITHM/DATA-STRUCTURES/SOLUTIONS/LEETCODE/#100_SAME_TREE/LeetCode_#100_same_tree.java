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
2020-Aug-29. Oleksii Saiun.
LeetCode_#100. Same Tree
https://leetcode.com/problems/same-tree/
*/

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
            if (p==null &&q==null)
        {
            return true;
        }
        
        if(p==null || q==null)
        {
            return false;
        }
        
        if (p.val==q.val)
        {
            return isSameTree(p.left, q.left) || isSameTree(p.right, q.right);
        }
        else
        {
            return false;
        }

    }

}
