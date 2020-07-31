import java.util.LinkedList;
import java.util.Queue;

/*Oleksii Saiun. 2020-Jul-30. Find next node in a same level of binary tree
 * 
 * we use DFS (level order) to find it
 * */
class Tree {
	Node node;

	public Tree(Node node) {
		this.node = node;
	}

	public void findNextNode(Node root, int key) {
		if (root == null) {
			return;
		}

		Node dummyNode = new Node(-9);
		Queue<Node> queue = new LinkedList<>();
		Integer nextKey =null;
		boolean flagKey=false;
		queue.offer(root);
		queue.offer(dummyNode);
		
		while (!queue.isEmpty() ) {

			Node tmp = queue.poll();

			if(tmp.getValue()==key )
			{
				flagKey=true;
				if(!queue.isEmpty() && queue.peek().getValue()!=dummyNode.getValue())
				{
					nextKey=queue.poll().getValue();
				}
				
			}
			
			if(tmp.getValue()==dummyNode.getValue())
			{

				if(!queue.isEmpty())
				{
					queue.offer(dummyNode);
				}
			}

			if (tmp.left != null) {
				queue.offer(tmp.left);
			}

			if (tmp.right != null) {
				queue.offer(tmp.right);
			}

		}
		
		System.out.println("nextNode:"+nextKey);
	}
	
	public void BFS(Node root) {
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

public class TreeNextNodeApp {

	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node7 = new Node(7);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		root.left = node10;
		node10.left = node8;
		node8.left = node7;

		node10.right = node16;
		node16.right = node17;
		node17.right = node19;
		node19.right = node2;
		node19.left = node3;

		root.right = node11;
		node11.right = node1;
		Tree tree = new Tree(root);
		tree.BFS(root);
		tree.findNextNode(root,8);

		/*
 *           9 
 *      10     11
 *   8     16     1
 * 7          17   
 *               19
 *             3    2		
		 * 
		 * 
		 * */

	}

}
