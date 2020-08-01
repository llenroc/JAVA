import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 2020-Aug-01. Oleksii Saiun. Check if nodes are cousins
 * 
 * Node are cousins if
 * 1) they have different parents
 * 2) parents are on the same level
 * 
/*
        1
     /     \
    2       3
   /       / \
  4       6   7
    \
     5   
     
   (4,6) = true;
   (2,3) = false;
   (6,7) = false;        
*/

class Tree {
	Node node;
	public Tree(Node node) {
		this.node = node;
	}	
	
	public boolean calcPath(Node root, Node keyNode, List<Integer> path)
	{ 
		if(root==null)
		{
			return false;
		}
		
		if(root.getValue()==keyNode.getValue())
		{
			path.add(root.getValue());
			return true;
		}
		if(calcPath(root.left,keyNode,path))
		{
			path.add(root.getValue());
			return true;
		}
		if(calcPath(root.right,keyNode,path))
		{
			path.add(root.getValue());
			return true;
		}
		
		return false;
		
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

			if ( tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}

		}
		System.out.println();
	}


	public boolean checkIfcousins (Node root, Node node1,Node node2)
	{
		if(node1==root || node2 ==root )
		{
			return false;
		}
		List<Integer> path1 = new ArrayList<>();
		List<Integer> path2 = new ArrayList<>(); 
		
		calcPath(root, node1, path1);
		calcPath(root, node2, path2);
		
		return (path1.size()==path2.size() && path1.get(1)!=path2.get(1));
	}
}

public class TreeCheckCousinsApp {
	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		root.left=node2;
		root.right=node3;
		node2.left=node4;

		
		root.right=node3;
		node3.left=node6;
		node3.right=node7;
		node4.right=node5;
		
		Tree tree  = new Tree(root);

		tree.BFS(root);
		System.out.println(tree.checkIfcousins(root, node6, node4));
		
/*
        1
     /     \
    2       3
   /       / \
  4       6   7
    \
     5   
     
   (4,6) = true;
   (2,3) = false;
   (6,7) = false;        
*/
	}
}
