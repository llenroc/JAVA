import java.util.LinkedList;
import java.util.Queue;

/* 2020-Aug-06. Oleksii Saiun. find Min and Max elements in BST

if a tree is BST then 
 -min element is in left corner
 -max element is in right corner

to find min we need recursively reach the latest left node
to find max we need recursively reach the latest right node
 * */

class Tree {
	Node node;

	Tree(Node node) {
		this.node = node;
	}

    
	public void findMin(Node root)
	{
		if (root == null) {
			return ;
		}
		
		findMin(root.left);				
		if(root.left==null)
		{
			root.displayValue();
		}			
       System.out.println();		
	}
	
	public void findMax(Node root)
	{
		if (root == null) {
			return ;
		}
		
		findMax(root.right);				
		if(root.right==null)
		{
			root.displayValue();
		}			
		System.out.println();		
	}	
	public void BSF(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node tmp = queue.poll();
			tmp.displayValue();

			if (tmp.left != null) {
				queue.offer(tmp.left);
			}

			if (tmp.right != null) {
				queue.offer(tmp.right);
			}
		}
		System.out.println();
	}
}

public class TreeMin_Max_in_BST_App {

	public static void main(String[] args) {
		Node root = new Node(7);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node13 = new Node(13);
		Node node14 = new Node(14);
		Node node15 = new Node(15);
		Node node16 = new Node(16);

		root.left = node4;
		

		node4.left = node2;
		node2.left= node1;
		node2.right=node3;

		root.right=node12;
		node12.left=node11 ;
		node12.right=node13;
		node13.left=node14;
		node13.right=node15;
		
		Tree tree = new Tree(root);
		tree.BSF(root);
		tree.findMin(root);
		tree.findMax(root);
		
		/*
		 *
              7
           4     12  
         2     11    13
        1  3       14  15
		 * 
		 *  min = 1
		 *  max = 15
		 * 
		 * 
		 */
		
	
	}

}
