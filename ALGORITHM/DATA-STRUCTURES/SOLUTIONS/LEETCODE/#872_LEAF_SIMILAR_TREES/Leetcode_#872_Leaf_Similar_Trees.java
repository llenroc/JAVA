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
LeetCode_#872. Leaf-Similar Trees
https://leetcode.com/problems/leaf-similar-trees/
*/
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        LinkedList<Integer> path1 = new LinkedList<>();
        LinkedList<Integer> path2 = new LinkedList<>();
        findLeaveNodes(root1,path1);
        findLeaveNodes(root2,path2);
        
        if ( path1.size() != path2.size() )
        {
            return false;
        }
        else
        {
            boolean statusOut=true;
            for (int j=0; j<path1.size();j++)
            {
                if( path1.get(j)!=path2.get(j))
                {
                    statusOut=false;
                    break;
                }
            }
            
            return statusOut;
        }
    }
    
    public void findLeaveNodes(TreeNode root, LinkedList<Integer> path)
    {
        if ( root==null)
        {
            return;
        }
        
        findLeaveNodes(root.left,path);
        findLeaveNodes(root.right,path);
        
        if ( root.left==null && root.right==null )
        {
            path.add(root.val);
            return;
        }
    }
}
