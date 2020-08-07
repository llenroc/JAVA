import java.util.LinkedList;
import java.util.Queue;

import tree.binarytree.traversal.vertical.HashTreeMap;

class Tree {
	Node root;
	HashTreeMap hash =new HashTreeMap();
	
	public Tree(Node root) {
		this.root = root;
	}

	public void preOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		preOrder(root.left);
		preOrder(root.right);
		root.displayValue();

	}
	
	public void convertToMirror(Node root)
	{
		if(root==null)
		{
			return;
		}
		convertToMirror(root.left);
		convertToMirror(root.right);
		Node tmpLeft=root.left;
		Node tmpRight=root.right;
		
		root.left=tmpRight;
		root.right=tmpLeft;
	}
	
	public void BSF(Node root) {
		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList();
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
public class TreeApp {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
        
		root.left=node3;
		root.right=node6;
		node3.left=node2;
		node3.right=node4;
		Tree tree = new Tree(root);
		
		tree.preOrder(root);
		System.out.println();
		tree.convertToMirror(root);
		tree.preOrder(root);
		
		
/*
 * 
 *  Tree:
 *               5 
 *             3     6
 *          2    4      
 *        
 *  Mirror      
 *                5
 *           6        3   
 *                  4   2
 * 
 * Pre-order of tree:
 * 2 4 3 6 5 
 * Pre-order of mirror tree:
 * 6 4 2 3 5 
 *                           
 * */
	} 

}
