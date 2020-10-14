/*2020-Oct-13. Oleksii Saiun. Find path between_two_nodes
	
	         5
	        / \
	       3   6
	      / \   \
	     2   4   7
	    /         \
	   1           8
	   
	   
	   Path[1,8] = [1, 2, 3, 5, 6, 7, 8];
	   Path[3,7] = [3, 5, 6, 7];
*/	   

class Tree {

	//public LinkedList<Integer> path1 = new LinkedList();
	public LinkedList<Integer> findPathBetweenTwoNodes(Node root, Node node1, Node node2)	
	{
		LinkedList<Integer> path1 = new LinkedList<>();
		LinkedList<Integer> path2 = new LinkedList<>();
		
		Node rootLCA= findLCA(root,node1,node2);
		
		path1 = findPath(rootLCA,node1.getValue());
		path2 = findPath(rootLCA,node2.getValue());

		//adding the second path in a reverse order without root
		for(int j=path2.size()-2;j>=0;j--)
		{
			int tmpVal = path2.get(j);
			path1.add(tmpVal);
		}
		return path1;
	}
	
	private LinkedList<Integer> findPath(Node root, int key)
	{
		LinkedList<Integer> path = new LinkedList();
		findPath(root,key,path);
		return path;
	}
	
	private boolean findPath(Node root, int key,LinkedList<Integer> path)
	{
		if(root==null)
		{

			return false;
		}

		
		if(root.getValue()==key)
		{
			path.add(root.getValue());
			return true;
		}
		
		if(findPath(root.left,key,path))
		{
			path.add(root.getValue());
			return true;
		}

		if(findPath(root.right,key,path))
		{
			path.add(root.getValue());
			return true;
		}


		return false;
	}
	
	private Node findLCA(Node root, Node p, Node q)
	{
		if(root==null)
		{
			return null;
		}
		
		if(root.getValue()==p.getValue())
		{
			return root; //MUST RETURN ROOT INSTEAD OF [P tree]. YOU NEED ROOT IN INRDER TO HAVE LINKS TO CHILDS NODES - LISE A SUBTREE
		}
		
		if(root.getValue()==q.getValue())
		{
			return root; //MUST RETURN ROOT INSTEAD OF [Q tree]. YOU NEED ROOT IN INRDER TO HAVE LINKS TO CHILDS NODES - LISE A SUBTREE
		}
		
		Node leftRoot =  findLCA(root.left,p,q);
		Node rightRoot =  findLCA(root.right,p,q);
		
		if(leftRoot!=null && rightRoot!=null)
		{
			return root;
		}
		else if(leftRoot!=null && rightRoot==null)
		{
			return leftRoot;
		}
		else if(leftRoot==null && rightRoot!=null)
		{
			return rightRoot;
		}		
		else
		{
			return null;
		}
				
	}
	public void BFS(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
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
		System.out.println();
	}
}

public class TreeFIndPathBetweenNodesApp {

	public static void main(String[] args) {
		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		
		root.left=node3;
		node3.left=node2;
		node3.right=node4;
		node2.left=node1;
		
		root.right=node6;
		node6.right=node7;
		node7.right=node8;

		Tree tree = new Tree();
		tree.BFS(root);

		System.out.println(tree.findPathBetweenTwoNodes(root, new Node(3), new Node(7)));
		

		
/*
		
	         5
	        / \
	       3   6
	      / \   \
	     2   4   7
	    /         \
	   1           8
	   
	   
	   Path[1,8] = [1, 2, 3, 5, 6, 7, 8];
	   Path[3,7] = [3, 5, 6, 7];
*/	   
	}
}



