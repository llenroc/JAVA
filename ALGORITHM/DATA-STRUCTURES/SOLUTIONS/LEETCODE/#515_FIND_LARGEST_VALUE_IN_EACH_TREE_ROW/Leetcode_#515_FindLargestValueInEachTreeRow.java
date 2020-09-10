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
LeetCode_#515. Find Largest Value in Each Tree Row
https://leetcode.com/problems/average-of-levels-in-binary-tree/
*/

class Solution {
    private List<Integer> listOfMaxValues = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        BFS(root);
        return listOfMaxValues;
    }
    
    public void BFS(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while( !queue.isEmpty() )
        {
            int sizeOfQueue = queue.size();
            int maxValueOfLevel= Integer.MIN_VALUE;
            
            for( int j=0; j<sizeOfQueue; j++)
            {
                TreeNode tmpNode = queue.poll();
                maxValueOfLevel = Math.max(maxValueOfLevel, tmpNode.val);
                
                if ( tmpNode.left!=null )
                {
                    queue.offer(tmpNode.left);
                }
                
                if ( tmpNode.right!=null )
                {
                    queue.offer(tmpNode.right);
                }
            }
            listOfMaxValues.add(maxValueOfLevel);
        }
    }
}
