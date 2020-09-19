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
2020-Sep-18. Oleksii Saiun.
LeetCode_#1302. Deepest Leaves Sum
https://leetcode.com/problems/deepest-leaves-sum/
*/

class Solution {    
    private LinkedList<LinkedList<Integer>> listAllLevels = new LinkedList<>();
    public int deepestLeavesSum(TreeNode root) {
        BFS(root);
        return calcSumOfLastLevelOfTree();
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
            
            LinkedList<Integer> listCurrentLevel = new LinkedList<>();
            for(int j=0; j<sizeOfQueue; j++)
            {
                TreeNode tmpNode = queue.poll();
                listCurrentLevel.add(tmpNode.val);
                
                if(tmpNode.left!=null)
                {
                    queue.offer(tmpNode.left);
                }
                
                if(tmpNode.right!=null)
                {
                    queue.offer(tmpNode.right);
                }
            }
            listAllLevels.add(listCurrentLevel);
        }
    }
    
    public int calcSumOfLastLevelOfTree()
    {
        int heightOfTree = listAllLevels.size();      
        LinkedList<Integer> tmpLevel = listAllLevels.getLast();
        int sum=0;
        for (int j=0; j<tmpLevel.size(); j++)
        {
            sum = sum + tmpLevel.get(j);
        }
        
        return sum;
    }
}
