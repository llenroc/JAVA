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
LeetCode_#94. Binary Tree Inorder Traversal
https://leetcode.com/problems/binary-tree-inorder-traversal/
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
        {
            return list;
        }
        
        Stack<TreeNode> queue= new Stack<>();
        TreeNode tmpNode = root;
        while(!queue.isEmpty() || tmpNode!=null)
        {
            if(tmpNode!=null)
            {
                queue.push(tmpNode);
                tmpNode=tmpNode.left;
                
            }
            else
            {
                tmpNode = queue.pop();
                list.add(tmpNode.val);
                tmpNode = tmpNode.right;
            }
        }
        return list;
    }
}
