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
2020-Sep-09. Oleksii Saiun.
LeetCode_#993. Cousins in Binary Tree
https://leetcode.com/problems/cousins-in-binary-tree/
*/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
    LinkedList<Integer> path1 = new LinkedList<>();
    LinkedList<Integer> path2 = new LinkedList<>();

    findPath(root, x, path1);    
    findPath(root, y, path2);    
        
    if (root==null)
    {
        return false;
    }
        
    if (path1.size()!=path2.size())
    {
        return false;
    }
    
        
        if ( path1.get(1)!=path2.get(1))
        {
            return true;
        }
    else
    {
        return false;
    }
    }
    
    public boolean findPath(TreeNode root, int key, LinkedList<Integer> path)
    {
        if(root==null)
        {
            return false;
        }
        
        if ( root.val==key )
        {
            path.add(root.val);
            return true;
        }
        
        if ( findPath(root.left, key, path) )
        {
            path.add(root.val);
            return true;
        }
        
        if ( findPath(root.right, key, path) )
        {
            path.add(root.val);
            return true;
        }
        
        return false;
    }
}
