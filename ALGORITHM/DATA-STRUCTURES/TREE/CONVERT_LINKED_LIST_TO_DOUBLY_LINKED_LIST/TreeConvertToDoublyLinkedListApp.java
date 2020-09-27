import java.util.LinkedList;
import java.util.Queue;


/*2020-Sep-27. Oleksii Saiun. 
 * Convert Binary Tree to Doubly LinkedList in [in-order] mode

 * */
class Tree {

	Node head;
	Node tail;

	Node nodeLinked=null;
    public void inOrder(Node root)
    {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		if(head==null)
		{
			Node newNode = new Node(root.getValue());
			head=newNode;
			tail=newNode;
		}
		else
		{
			Node newNode = new Node(root.getValue());
			head.right=newNode;
			newNode.left=head;
			head=newNode;
		}
		inOrder(root.right);
    }

    public void diplayAllLinkedListMoveToLeft()
    {
    	Node curr= head;
    	while(curr!=null)
    	{
    		curr.displayValue();
    		curr=curr.left;
    	}
    	System.out.println();
    }
    
    public void diplayAllLinkedListMoveToRight()
    {
    	Node curr= tail;
    	while(curr!=null)
    	{
    		curr.displayValue();
    		curr=curr.right;
    	}
    	System.out.println();
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
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		
		root.left=node2;
		root.right=node5;
		node2.left=node3;
		node2.right=node4;
		node5.right=node6;

		Tree tree = new Tree();

		tree.BFS(root);
		tree.inOrder(root);
		System.out.println("Print Linked list - move to left:");
		tree.diplayAllLinkedListMoveToLeft();
		System.out.println("Print Linked list - move to right:");
		tree.diplayAllLinkedListMoveToRight();
		



/*
    1
   / \
  2   5
 / \   \
3   4   6   

Level Order:
1 2 5 3 4 6 
Print Linked list - move to left:
6 5 1 4 2 3 
Print Linked list - move to right:
3 2 4 1 5 6 



*/
		
	}

}


