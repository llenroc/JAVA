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
LeetCode_#965. Univalued Binary Tree
https://leetcode.com/problems/univalued-binary-tree/

[Unival tree]=[Univalued tree] is a tree where each node have the same values
Example
1)
 5
 result: true
 
2)
     5
    /  \
   5    5
 result: true 
 
3)
     5
       \
        5
 result: true  
4)
     5
   /   \
  2     5
 result: false   

 (!) Simple, but tricky implementation
  The solution is based on visa verse(!):
------
          if (root==null)
        {
            return true;
        }
------        
 
*/
class Solution {
    public boolean isUnivalTree(TreeNode root) {                
        return isUnivalTree(root, root.val);
    }
    
    public boolean isUnivalTree (TreeNode root, int key)
    {
        if (root==null)
        {
            return true;
        }
        
        if(root.val!=key)
        {
            return false;
        }
        
        return isUnivalTree(root.left,key) && isUnivalTree(root.right,key);
    }
}
