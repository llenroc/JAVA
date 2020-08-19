import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-17. Oleksii Saiun. Find Largest value in each row of a tree 
 * 
 * */

class Tree {
	private Node node;

	public Tree(Node node) {
		this.node = node;
	}

//    ---------



	public void findlargestValues(Node root) {
		if (root == null) {
			return;
		}
		Node dummyNode = new Node(Integer.MIN_VALUE);
		int height = 0;
		int maxValue;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(dummyNode);

		maxValue = root.getValue();

		while (!queue.isEmpty()) {
			Node tmpNode = queue.poll();

			if (tmpNode.getValue() == dummyNode.getValue()) {
				height = height + 1;
				// reset [maxValue] when we jump to the next level
				System.out.println("[" + height + "]:" + maxValue);
				maxValue = -999; // you can take any min value
				if (!queue.isEmpty()) {
					queue.offer(dummyNode);
				}
			} else {
				maxValue = Integer.max(maxValue, tmpNode.getValue());
			}

			if (tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}

			if (tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}
		}
	}
}

public class TreeLargestValueInEachRowApp {

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

		tree.findlargestValues(root);
		System.out.println();

        /*
         *           9 
         *        3     10 
         *      2     8     16
         *    1   6       17   0
         *          4
         *       19   28
         * out:      
         *       
         *   [1]:9
         *   [2]:10
         *   [3]:16
         *   [4]:17
         *   [5]:4
         *   [6]:28    
         *       
         */
	}

}
