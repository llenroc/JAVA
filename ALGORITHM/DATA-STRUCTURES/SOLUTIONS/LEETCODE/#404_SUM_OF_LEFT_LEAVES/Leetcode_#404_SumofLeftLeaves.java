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
LeetCode_#404. Sum of Left Leaves
https://leetcode.com/problems/sum-of-left-leaves/
*/


class Solution {
    private List<Integer> list = new LinkedList<>();
    
    public int sumOfLeftLeaves(TreeNode root) {

        findLeaveNodes(root, null);
        return sumOfLeaveNodes();
    }
    
    
    public void findLeaveNodes(TreeNode root, String flag)
    {
        if(root==null)
        {
            return;
        }
        

        
        findLeaveNodes(root.left, "left");
        findLeaveNodes(root.right, "right");
        
        if(root.left==null && root.right==null && flag=="left")
        {
            list.add(root.val);
        }

    }
    
    private int sumOfLeaveNodes()
    {
        int sum=0;
        for(int j=0; j<list.size(); j++)
        {
            sum = sum + list.get(j);
        }
        
        return sum;
    }
    
}
