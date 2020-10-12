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
2020-Oct-12. Oleksii Saiun.
LeetCode_257. Binary Tree Paths
https://leetcode.com/problems/binary-tree-paths/
*/

class Solution {
    private LinkedList<Integer> currentPath = new LinkedList();
    private LinkedList<String> allPath = new LinkedList();
    
    public List<String> binaryTreePaths(TreeNode root) {
        findPath(root);
        return allPath;
    }
    
    
    private void findPath(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        currentPath.add(root.val);
        
        if(root.left==null && root.right==null)
        {
            String strCurrPath = constructStringPresentationOfPath();
            allPath.add(strCurrPath);
        }
        
        findPath(root.left);
        findPath(root.right);
        
        currentPath.removeLast();
    }
    
    private String constructStringPresentationOfPath()
    {
        StringBuilder outPath = new StringBuilder();
        outPath.append(currentPath.get(0));
        for (int j=1; j<currentPath.size(); j++)
        {
            outPath.append("->"+currentPath.get(j));
        }
        return String.valueOf(outPath);
    }
}
