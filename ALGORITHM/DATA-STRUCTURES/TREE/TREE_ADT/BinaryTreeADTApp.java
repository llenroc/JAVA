/**
 * Oleksii Saiun. 2020-JUl-17. Queue from ADT
 * 
 *
 */
class Tree<T> {
	Node<T> root;

	public Tree(Node root) {
		this.root = root;
	}

public void BFS(Node root)
{
	if(root==null)
	{
		return;
	}
	
	QueueADT<Node> queue = new QueueADT();
	queue.offer(root);
	
	while(!queue.isEmpty())
	{
		Node tmpNode = queue.poll();
		tmpNode.displayValue();
		
		if(tmpNode.left!=null)
		{
			queue.offer(tmpNode.left);
		}
		
		if(tmpNode.right!=null)
		{
			queue.offer(tmpNode.right);
		}
	}
}
}

public class BinaryTreeADTApp {
	public static void main(String[] args) {
		Node<Integer> root = new Node<>(9);
		Node<Integer> node3 = new Node<>(3);
		Node<Integer> node2 = new Node<>(2);
		Node<Integer> node1 = new Node<>(1);
		Node<Integer> node11 = new Node<>(11);
		Node<Integer> node10 = new Node<>(10);
		Node<Integer> node8 = new Node<>(8);
		Node<Integer> node16 = new Node<>(16);
		Node<Integer> node17 = new Node<>(17);
		root.left = node3;
		node3.left = node2;
		node2.left = node1;
		node2.right = node11;

		root.right = node10;
		node10.left = node8;
		node10.right = node16;
		node16.right = node17;

		Tree<Node> tree=new Tree(root);
		tree.BFS(root);


		  /*
	      *          9 
	      *       3      10  
	      *    2       8  16
	      *  1  11           17
	      */

	}

}
