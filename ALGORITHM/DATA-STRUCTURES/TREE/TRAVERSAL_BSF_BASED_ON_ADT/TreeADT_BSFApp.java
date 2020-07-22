/*
 * 2020-Jul-21. Oleksii Saiun
 * Creating Tree based on ADT and BSF Traversal
 * */

class Tree
{
	Node root;
	
	public Tree(Node root)
	{
		this.root=root;
	}
	
	public void BSF(Node root)
	{
		if (root==null)
		{
			return;
		}
		
		QueueADT queue = new QueueADT();
		queue.offer(root);
		
		while(!queue.isEmpty())
		{
			Node tmp = queue.poll();
			tmp.displayValue();
			
			if(tmp.left!=null)
			{
				queue.offer(tmp.left);
			}
			
			if(tmp.right!=null)
			{
				queue.offer(tmp.right);
			}			
		}
	}
}
public class TreeADT_BSFApp {
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
		Tree tree = new Tree(root);
		tree.BSF(root);
	       /*
      *          9 
      *       3      10  
      *    2       8  16
      *  1  11           17
      * */

	}

}
