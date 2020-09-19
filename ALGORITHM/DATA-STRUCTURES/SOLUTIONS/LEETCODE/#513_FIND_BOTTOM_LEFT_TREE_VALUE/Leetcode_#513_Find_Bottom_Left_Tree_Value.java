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
2020-Sep-18. Oleksii Saiun.
LeetCode_#513. Find Bottom Left Tree Value
https://leetcode.com/problems/find-bottom-left-tree-value/
*/

class Solution {
    Integer currentMinIndex = Integer.MAX_VALUE;
    Integer tmpMinNodeValue;
    
    public int findBottomLeftValue(TreeNode root) {
           preOrder(root,0);
           return tmpMinNodeValue;
    }
    
    
    // index:
    // movement to left: indeindex-1
    // movement to right: index index-1
    public void preOrder(TreeNode root,int index)
    {
        if (root==null)
        {
            return;
        }
        
        if (index<currentMinIndex)
        {
            currentMinIndex=index;
            tmpMinNodeValue = root.val;
        }
        preOrder(root.left, index-1);
        preOrder(root.right, index-1);
    }
}
