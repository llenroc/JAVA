/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
2020-Sep-29. Oleksii Saiun.
LeetCode_#449. Serialize and Deserialize BST
https://leetcode.com/problems/serialize-and-deserialize-bst/
*/

public class Codec {
 private int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder("");
        buildSerialize(root, str);
        return String.valueOf(str);
    }
    
    public void buildSerialize(TreeNode root, StringBuilder str)
    {
        if (root==null)
        {
            str.append("null,");
            return;
        }
        
        str.append(root.val+",");
        buildSerialize(root.left,str);
        buildSerialize(root.right,str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return buildDeserialize(arr);        
    }
    
        public TreeNode buildDeserialize(String[] arr) {
            if (index>=arr.length)
            {
                return null;
            }
            
            String s = arr[index];
            index=index+1;
            
            if (s.equals("null"))
            {
                return null;
            }
            
            TreeNode leftNode = buildDeserialize(arr);
            TreeNode rightNode = buildDeserialize(arr);
            
            TreeNode root = new TreeNode(Integer.valueOf(s));
            root.left=leftNode;
            root.right=rightNode;
            
            return root;
        }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
