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
LeetCode_#145. Binary Tree Postorder Traversal
https://leetcode.com/problems/binary-tree-postorder-traversal/
*/

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
        if (root==null)
        {
            return list;
        }
        
        Stack<TreeNode> stack1 = new Stack();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack();
        
        while(!stack1.isEmpty())
        {
            TreeNode tmpNode = stack1.pop();
            stack2.push(tmpNode);
            
            if(tmpNode.left!=null)
            {
                stack1.push(tmpNode.left);
            }
            
            if(tmpNode.right!=null)
            {
                stack1.push(tmpNode.right);
            }            
        }
        
        while(!stack2.isEmpty())
        {
            list.add(stack2.pop().val);
        }
        return list;
    }
}
