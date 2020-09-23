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
LeetCode_#144. Binary Tree Preorder Traversal
https://leetcode.com/problems/binary-tree-preorder-traversal/submissions/
*/

class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<>();
      if (root==null)
      {
          return list;
      }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty())
        {
            TreeNode tmpNode = stack.pop();
            list.add(tmpNode.val);
            
            if (tmpNode.right!=null)
            {
                stack.push(tmpNode.right);
            }
            
            if (tmpNode.left!=null)
            {
                stack.push(tmpNode.left);
            }            
            
        }
        
         return list;       
    }
}
