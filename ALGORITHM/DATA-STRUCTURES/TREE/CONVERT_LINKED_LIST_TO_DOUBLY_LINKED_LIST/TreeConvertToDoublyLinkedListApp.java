import java.util.LinkedList;
import java.util.Queue;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree {

	Stack<Integer> stack = new Stack<>();

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}
		inOrder(root.left);
		stack.push(root.getValue());
		inOrder(root.right);
	}

	public Node convert(Node root) {
		inOrder(root);

		Node newNode = new Node(stack.pop());

		Node head = newNode;
		Node tail = newNode;
		head.left=tail;
		tail.right=head;
		
		while (!stack.isEmpty()) {

			newNode = new Node(stack.pop());

			newNode.right = head;
			head.left = newNode;
			head = newNode;
			head.left = tail;
			tail.right = head;

		}
		return head;
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

public class TreeConvertToDoublyLinkedListApp {
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node root = new Node(4);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node5 = new Node(5);

		root.left = node2;
		root.right = node5;
		node2.left = node1;
		node2.right = node3;

		tree.BFS(root);

		Node out = tree.convert(root);
		out.displayValue();
		System.out.println();
		out.right.displayValue();
	    System.out.println();
		out.right.right.displayValue();
		System.out.println();
		out.right.right.right.displayValue();
		System.out.println();
		out.right.right.right.right.displayValue();
		System.out.println();
		System.out.println("moves a cycle:");
		out.right.right.right.right.right.displayValue();


		/*
		 *               4
		 *             /   \
		 *            2     5
		 *          /  \
		 *         1    3
		 * 
		 */	
	}

}
