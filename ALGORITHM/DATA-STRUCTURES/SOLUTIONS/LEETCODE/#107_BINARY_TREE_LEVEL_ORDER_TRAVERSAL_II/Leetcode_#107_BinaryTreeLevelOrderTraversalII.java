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
LeetCode_#107. Binary Tree Level Order Traversal II
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
*/

class Solution {
    private LinkedList<LinkedList<Integer>> listAllLevels = new LinkedList<>();
    private List<List<Integer>> listAllLevelsReverse = new LinkedList<>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        BFS(root);
        
        for (int j=listAllLevels.size()-1;j>=0;j--)
        {
            List<Integer> tmpList=listAllLevels.get(j);
            listAllLevelsReverse.add(tmpList);
        }
        return listAllLevelsReverse;
    }
    
    public void BFS(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        
        while ( !queue.isEmpty() )
        {
            int sizeOfQueue = queue.size();            
            LinkedList<Integer> listCurrentLevel = new LinkedList<>();
            
            for (int j=0; j<sizeOfQueue; j++)
            {
                TreeNode tmpNode = queue.poll();
                listCurrentLevel.add(tmpNode.val);
                if ( tmpNode.left!=null )
                {
                    queue.offer(tmpNode.left);
                }
                
                if ( tmpNode.right!=null )
                {
                    queue.offer(tmpNode.right);
                }
            }
            listAllLevels.addLast(listCurrentLevel);
        }
    }
}
