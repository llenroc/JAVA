import java.util.LinkedList;
import java.util.Queue;

import tree.binarytree.traversal.vertical.HashTreeMap;

/*Oleksii Saiun. 2020-Aug-08. Check if a tree is symmetric
 * 
 * condition must match:
 * 
 * [leftSubtre].left = [rightSubtre].right
 * [leftSubtre].right = [rightSubtre].left 
 * 
 *               1 
 *            2      2
 *          3   4  4   3
 *        5              5

 * */
class Tree {
	Node root;
	HashTreeMap hash =new HashTreeMap();
	
	public Tree(Node root) {
		this.root = root;
	}

	public boolean check(Node root)
	{
		if(root==null)
		{
			return false;
		}
		
		return isSymmetric(root.left,root.right);
	}
	public boolean isSymmetric(Node rootA,Node rootB)
	{
		
		if(rootA==null || rootB==null)
		{
			return rootA==rootB;
		}
		

		if(rootA.getValue() != rootB.getValue())
		{
			return false;
		}

		return isSymmetric(rootA.left,rootB.right) && isSymmetric(rootA.right,rootB.left);
		
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
	}
}
public class TreeCheckIfSymmetricApp {

	public static void main(String[] args) {
		Node root = new Node(1);
		Node node2_A = new Node(2);
		Node node2_B = new Node(2);
		Node node3_A = new Node(3); 
		Node node3_B = new Node(3);
		Node node4_A = new Node(4);
		Node node4_B = new Node(4);
		Node node5_A = new Node(5);
		Node node5_B = new Node(5);
		Node node6 = new Node(6);
		
		
		root.left=node2_A;
		root.right=node2_B;
		
		node2_A.left=node3_A;
		node2_A.right=node4_A;
		node3_A.left=node5_A;
		
		node2_B.left=node4_B;
		node2_B.right=node3_B;
		node3_B.right=node5_B;		
		
		Tree tree = new Tree(root);
		tree.BSF(root);
		System.out.println();
        System.out.println(tree.check(root));
		
/*
 * 
 * 
 *  *             1 
 *            2      2
 *          3   4  4   3
 *        5              5

           
 * */
	}

}
