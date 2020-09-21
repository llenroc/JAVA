import java.util.LinkedList;
import java.util.Queue;


/*2020-Sep-21. Oleksii Saiun. 
 * Merge two binary trees
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */
class Tree {


    public Node mergeTrees(Node root1, Node root2) {
        if (root1==null && root2==null)
        {
        	return null;
        }
        
        if (root1==null && root2!=null)
        {
        	return root2;
        }
        
        if (root1!=null && root2==null)
        {
        	return root1;
        }

        Node newNode = new Node(root1.getValue()+root2.getValue());
        newNode.left=mergeTrees(root1.left,root2.left);
        newNode.right=mergeTrees(root1.right,root2.right);
        
        return newNode;
    }
    
    
	public void BFS(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();
			tmpNode.displayValue();

			if (tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}
		}
		System.out.println();
	}

}

public class TreeMergeTwoTreesApp {

	public static void main(String[] args) {
		Node rootA = new Node(1);
		Node node2_A = new Node(2);
		Node node3_A = new Node(3);
		Node node5_A = new Node(5);
		
		Node rootB = new Node(2);
		
		Node node1_B = new Node(1);
		Node node3_B = new Node(3);
		Node node4_B = new Node(4);
		Node node7_B = new Node(7);

		Tree tree = new Tree();
		rootA.left=node3_A;
		rootA.right=node2_A;
		node3_A.left=node5_A;
		
		rootB.left=node1_B;
		rootB.right=node3_B;
		node1_B.right=node4_B;
		node4_B.right=node7_B;
		tree.BFS(rootA);
		tree.BFS(rootB);
        Node rootMerged = tree.mergeTrees(rootA, rootB);
        tree.BFS(rootMerged);


		/*
 * Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7


	        * 
	        * 
	         *       
	         */
		
	}

}

