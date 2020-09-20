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
2020-Sep-19. Oleksii Saiun.
LeetCode_#958. Check Completeness of a Binary Tree
https://leetcode.com/problems/check-completeness-of-a-binary-tree/
*/

class Solution {
    private boolean isNullNode=false;
    private boolean isComplete=true;
    public boolean isCompleteTree(TreeNode root) {
        BFS(root);
        return isComplete;
    }
    
    // if tree is complete than there is no any gaps. 
    public void BFS(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
      Queue<TreeNode> queue = new LinkedList<>();
 	   queue.offer(root);
 	   
 	   while(!queue.isEmpty())
       {
           TreeNode tmpNode = queue.poll();
           
           if (tmpNode==null)
           {
               isNullNode=true;
           }
           else
           {
               //if node is empty the second time then there are gaps and tree is not complete
            if (isNullNode)
            {
                isComplete=false;
                return;
            }
               // it is tricky. it does not use common construction if (tmpNode.left!=null) {...}
               queue.offer(tmpNode.left);
               queue.offer(tmpNode.right);
               
           }
       }
    }
}
