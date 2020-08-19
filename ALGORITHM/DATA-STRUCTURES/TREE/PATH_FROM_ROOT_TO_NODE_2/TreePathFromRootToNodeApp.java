import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-19. Oleksii Saiun. Find path from root to node
 * Second approach. We keep data in LinkedList
 * */
class Tree {
	Node node;
	private LinkedList<Node> listPath = new LinkedList();
	
	public Tree(Node node) {
		this.node = node;
	}

	public void BSF(Node root) {
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
	
	public void findPath(Node root, Node keyNode) {
		if (root == null) {
			return;
		}

		listPath.add(root);
		if (root.getValue() == keyNode.getValue()) {
			printPath();
			return;
		}

		findPath(root.left, keyNode );
		findPath(root.right, keyNode);

		listPath.removeLast();
	}

	
	private void printPath() {
		for (Node n : listPath) {
			n.displayValue();
		}
	}

}

public class TreePathFromRootToNodeApp {

	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node0 = new Node(0);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		Node node28 = new Node(28);

		root.left = node3;
		root.right = node10;
		node3.left = node2;
		node10.left = node8;
		node10.right = node16;
		node2.left = node1;
		node2.right = node6;
		node6.right = node4;
		node16.left = node17;
		node16.right = node0;
		node4.left = node19;
		node4.right = node28;
		Tree tree = new Tree(root);

		tree.BSF(root);
		tree.findPath(root, node17);
        /*
         *           9 
         *        3     10 
         *      2     8     16
         *    1   6       17   0
         *          4
         *       19   28 
         *       
         */
	}

}
