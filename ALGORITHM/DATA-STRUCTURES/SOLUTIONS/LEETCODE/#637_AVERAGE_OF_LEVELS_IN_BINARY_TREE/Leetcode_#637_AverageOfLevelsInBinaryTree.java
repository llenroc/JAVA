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
2020-Sep-08. Oleksii Saiun.
LeetCode_#637. Average of Levels in Binary Tree
https://leetcode.com/problems/average-of-levels-in-binary-tree/
*/

class Solution {
    private List<Double> listAvgOfLevels = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        BFS(root);
        return listAvgOfLevels;        
    }
    
  
    private void BFS(TreeNode root)
    {
        if ( root==null)
        {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while( !queue.isEmpty() )
        {
            int sizeOfQueue = queue.size();
            double sumOfLevelNodes=0;
            double avgOfLevelNodes =0;
            for(int j=0; j<sizeOfQueue; j++)
            {
                TreeNode tmpNode = queue.poll();
                sumOfLevelNodes = sumOfLevelNodes + tmpNode.val;
                if( tmpNode.left!=null )
                {
                    queue.offer(tmpNode.left);
                }
                
                if( tmpNode.right!=null )
                {
                    queue.offer(tmpNode.right);
                }
            }
            
            avgOfLevelNodes=(double) sumOfLevelNodes/sizeOfQueue;
            listAvgOfLevels.add(avgOfLevelNodes);
        }
        
    }
     
    
}
