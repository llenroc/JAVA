import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* 2020-Aug-10. Oleksii Saiun. Print diagonals
              7
           4     12  
         2     11    14
        1  3       13  15

diagonals:
 0: 7 12 14 15 
-1: 13 11 4 
-2: 2 3 
-3: 1 

idea of figuring out:
 -root=0;
 -when move to right than index does not change
 -when move to left than index = index-1

 * */

class Tree {
	Node node;

	MyHashMap hashmap = new MyHashMap();
	Tree(Node node) {
		this.node = node;				
	}
	
	public void findDiameter(Node root, int index) {
		if(root==null)
		{
			return;
		}
		
		hashmap.insert(index, root);
		findDiameter(root.right,index);
		findDiameter(root.left,index-1);

	}
	
	public void displayDiameters()
	{
		hashmap.displayAll();
	}
	
	public void displaySumOfDiameters()
	{
		hashmap.displaySumOfAll();
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

public class TreeFindDiameterApp {

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
		node12.right=node14;
		node14.left=node13;
		node14.right=node15;
		
		Tree tree = new Tree(root);
		tree.BSF(root);
		System.out.println();
		tree.findDiameter(root, 0);
		System.out.println();
		tree.displayDiameters();
	//	System.out.println();
	//	tree.displaySumOfDiameters();
		/*
		 *
              7
           4     12  
         2     11    14
        1  3       13  15
		 * 
		 *  
		 * 
		 * 
		 */
		
	
	}

}
