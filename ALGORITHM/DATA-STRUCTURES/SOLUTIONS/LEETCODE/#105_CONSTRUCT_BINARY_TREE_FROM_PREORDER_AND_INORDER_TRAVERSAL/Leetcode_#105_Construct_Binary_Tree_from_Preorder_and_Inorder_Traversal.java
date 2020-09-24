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
LeetCode_#105. Construct Binary Tree from Preorder and Inorder Traversal
https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
*/

class Solution {
    private int indexPreOrder=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hashmap = buildHashMap(inorder);
        return buildTree(preorder, inorder, 0, preorder.length-1, hashmap);
    }
    
    private HashMap<Integer, Integer> buildHashMap(int[] arr)
	{
	    HashMap<Integer, Integer> hashmap = new HashMap<>();
	    for(int j=0; j<arr.length;j++)
	    {
	    	hashmap.put(arr[j],j);
	    }
	    return hashmap;
	}
    
    private TreeNode buildTree(int[] preorder, int[] inorder, int startIndexInOrder, int endIndexInOrder, HashMap<Integer, Integer> hashmap)
    {
        if (startIndexInOrder>endIndexInOrder)
        {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[indexPreOrder]);
        int key = preorder[indexPreOrder];
        int indexInOrder = hashmap.get(key);
        indexPreOrder=indexPreOrder+1;
        root.left = buildTree(preorder, inorder, startIndexInOrder, indexInOrder-1,hashmap);    
        root.right = buildTree(preorder, inorder, indexInOrder+1, endIndexInOrder,hashmap);    
        
        return root;
    }
    

    
}
