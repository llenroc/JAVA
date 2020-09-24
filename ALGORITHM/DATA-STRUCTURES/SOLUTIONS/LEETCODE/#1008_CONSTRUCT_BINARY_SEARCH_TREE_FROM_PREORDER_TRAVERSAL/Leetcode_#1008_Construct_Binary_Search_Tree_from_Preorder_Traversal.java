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
2020-Sep-23. Oleksii Saiun.
LeetCode_#1008. Construct Binary Search Tree from Preorder Traversal
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
*/

class Solution {
    public TreeNode bstFromPreorder(int[] arr) {

        
        TreeNode root = new TreeNode(arr[0]);
        for (int j=1; j<arr.length; j++)
        {
            insertIntoBST(root, arr[j]);
        }
        
        return root;
    }
    
    private void insertIntoBST(TreeNode root, int key)
    {
        TreeNode newNode = new TreeNode(key);
        while(1==1)
        {
            if (key<root.val)
            {
                if (root.left==null)
                {
                    root.left = newNode;
                    return;
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {
                if (root.right==null)
                {
                    root.right = newNode;
                    return;
                }
                else
                {
                    root = root.right;
                }
            }
        }
    }
}
