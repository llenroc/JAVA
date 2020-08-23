import java.util.LinkedList;
import java.util.Queue;

/*2020-Aug-23. Oleksii Saiun. Find path from root to node
 * 
 * note:
 * drawback of this solution search nodes have to exist in a tree
 * We can improve it , preliminary, check if they exist
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
	

	
	public Node lowestCommonAncestor(Node root, Node keyNode1, Node keyNode2)
	{
		if (root==null)
		{
			return null;
		}
		
		if(root.getValue() == keyNode1.getValue())
		{
			return root;
		}
		
		if(root.getValue() == keyNode2.getValue())
		{
			return root;
		}
		
        Node leftNode = lowestCommonAncestor(root.left,keyNode1,keyNode2);
        Node rightNode = lowestCommonAncestor(root.right,keyNode1,keyNode2);
		
        
        
        //we consider all variants
        if(leftNode!=null && rightNode!=null)   // if both not null then return LCA
        {
        	return root;
        }
        else if (leftNode!=null && rightNode==null)
        {
        	return leftNode;
        }
        else if (rightNode!=null && leftNode==null)
        {
        	return rightNode;
        }
        else
        {
        	return null;
        }
	}

 

	
	public void printPath() {
		
		for (Node n : listPath) {
			n.displayValue();
		}
		System.out.println();	
		
	}

  
}

public class TreeLowestCommonAncestorApp2 {

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
		Node node49 = new Node(49);

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

      System.out.println(tree.lowestCommonAncestor(root, node0, node17).getValue());
      
		

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
