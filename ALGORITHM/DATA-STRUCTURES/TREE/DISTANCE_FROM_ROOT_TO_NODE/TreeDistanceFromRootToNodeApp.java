import java.util.LinkedList;
import java.util.Queue;


/*2020-Aug-24. Oleksii Saiun. Find a distance(=length) from root to node
 * 
 * */
class Tree {
	Node node;
	
	public Tree() {
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
	
	
	public int calcDistanceRootToNode(Node root, Node keyNode)
	{
		int out=-1;
		if(root==null)
		{
			return out;
		}
		
		int leftDist=calcDistanceRootToNode(root.left,keyNode);
		int rightDist=calcDistanceRootToNode(root.right,keyNode);
		
		if(root.getValue()==keyNode.getValue() || leftDist>-1 || rightDist>-1)
		{
			out = Math.max(leftDist, rightDist)+1;
		}
		
		return out;
	}
	
}


public class TreeDistanceFromRootToNodeApp {

	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node10 = new Node(10);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node0 = new Node(0);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node11 = new Node(11);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		Node node28 = new Node(28);
		Node node49 = new Node(49);

		root.left = node3;
		root.right = node10;
		node3.left = node2;
		node10.left = node8;
		node10.right = node16;
		node2.left = node1;
		node1.left=node7;
		node7.left=node11;
		node2.right = node6;
		node6.right = node4;
		node16.left = node17;
		node16.right = node0;
		node4.left = node19;
		node4.right = node28;
		node19.left=node49;
		Tree tree = new Tree();

		tree.BSF(root);
		
     	System.out.println(tree.calcDistanceRootToNode(root, node28));
	
		

/*
         *           9 
         *        3     10 
         *      2     8     16
         *    1   6       17   0
         *   7       4
         * 11     19   28 
         *      49 
         *      
         *      
         *      [root,node28] = 5;
         */

	}

}

