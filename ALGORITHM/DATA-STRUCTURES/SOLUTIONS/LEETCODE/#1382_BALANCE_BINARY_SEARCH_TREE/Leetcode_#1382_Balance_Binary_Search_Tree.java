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
2020-Sep-17. Oleksii Saiun.
LeetCode_#1382. Balance a Binary Search Tree
https://leetcode.com/problems/balance-a-binary-search-tree/
*/

class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    
    public TreeNode balanceBST(TreeNode root) {
        populateListOfElements(root);
        
        return createBT(root,0,list.size()-1);
    }
    
    public void populateListOfElements(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        
        populateListOfElements(root.left);
        list.add(root.val);
        populateListOfElements(root.right);
    }
    
    public TreeNode createBT(TreeNode root, int startIndex, int endIndex)
    {
        if (startIndex>endIndex)
        {
            return null;
        }
        
        int midIndex = (startIndex+endIndex)/2;
        TreeNode newNode = new TreeNode(list.get(midIndex));
        newNode.left = createBT(root, startIndex, midIndex-1);
        newNode.right = createBT(root, midIndex+1, endIndex);
        
        return newNode;
    }
}
