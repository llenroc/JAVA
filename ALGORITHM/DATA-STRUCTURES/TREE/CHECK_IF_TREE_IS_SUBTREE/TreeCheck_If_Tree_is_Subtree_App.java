import java.util.LinkedList;
import java.util.Queue;

/* 2020-Aug-06. Oleksii Saiun. Check if tree is subtree of another tree


note: two nulls are [true]

		if (root1 == null && root2 == null) {
			return true;
		} 
 * */
class Tree {
	Node root;

	public Tree(Node root) {
		this.root = root;
	}

	public boolean isSubtree(Node rootParent, Node rootChild)
	{
		if (rootParent==null)
		{
			return false;
		}
		
		if(isSame(rootParent,rootChild))
		{
			return true;
		}
		else
		{
			return isSubtree(rootParent.left,rootChild) || isSubtree(rootParent.right,rootChild);
		}
	}
	public boolean isSame(Node root1, Node root2) {
		// null == null  = > true
		if (root1 == null && root2 == null) {
			return true;
		} 
		
		if (root1 == null || root2 == null) {
			return false;
		} 

		if (root1.getValue() == root2.getValue()) {
			return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
		} else {
			return false;
		}
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

public class TreeCheck_If_Tree_is_Subtree_App {
	public static void main(String[] args) {
		Node root1 = new Node(26);
		Node node10 = new Node(10);
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node7 = new Node(7);
		Node node9 = new Node(9);

		Node node6 = new Node(6);

		root1.left = node10;
		node10.left = node4;
		node10.right = node6;
        node4.left=node0;
        
		root1.right = node1;
		node1.right = node3;
		node3.left = node7;
		node3.right = node9;

		Node root2 = new Node(10);
		Node node4B = new Node(4);
		Node node6B = new Node(6);
		Node node0B = new Node(0);
		root2.left=node4B;
		root2.right=node6B;
		node4B.left=node0B;
		Tree tree = new Tree(root1);
		tree.BFS(root1);
		tree.BFS(root2 );
		System.out.println(tree.isSubtree(root1, root2)); 

	    /*
parent
        26
      /   \
     10    1 
   /    \    \
  4     6     3 
 /            7  9
0

child1:

     10   
   /    \    
  4     6     
 /           
0

if [child1] is subtree of [root]? - true

child2:

     10   
   /    \    
  4     6     


if [child1] is subtree of [root]? - false



 * 
 * */
	}

}
