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
2020-Sep-03. Oleksii Saiun.
LeetCode_#111. Minimum Depth of Binary Tree
https://leetcode.com/problems/minimum-depth-of-binary-tree/
*/

class Solution {
    private Integer minSize =Integer.MAX_VALUE;
    private LinkedList<Integer> listOfPaths = new LinkedList<>();
    
    public int minDepth(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        findPath(root);    
        return minSize;
    }

    public void findPath(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        listOfPaths.addLast(root.val);
        if (root.left==null && root.right==null)
        {
            int currentSize = listOfPaths.size();
            minSize = Math.min(currentSize, minSize);            
        }
        
        findPath(root.left);
        findPath(root.right);
        listOfPaths.removeLast();
        return;
    }
        
}
