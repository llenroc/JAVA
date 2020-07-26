/* 2020-Jul-25. Oleksii Saiun
 * Top View
 * 
 * The idea is make a vertical traversal
 *  1) root is assigned index=0
 *  2) left move is  assigned index=index - 1
 *  3) right move is  assigned index=index + 1
 * 
 * 
 *  Traversal is inserted into TreeHash and then output
 *  We use TreeHash, because it stores values by index in sorted way
 *  
 *  and than take the first left element from TreeMap 
 *          9 
 *       3      10  
 *    2       8  16
 *  1  11           17
 *                    19
 * Result:                          
    [-3] 1 
    [-2] 2 
    [-1] 3
    [0] 9 
    [1] 10 
    [2] 16 
    [3] 17 
    [4] 19 
*        
*        
* */	

class Tree {
	Node root;
	HashTreeMap hash =new HashTreeMap();
	
	public Tree(Node root) {
		this.root = root;
	}

	
	private void populateVerticalTraversal(Node root, int index)
	{
		if (root==null)
		{
			return;
		}
		
		hash.addValue(index, root);
		

		populateVerticalTraversal(root.left,index-1);
		populateVerticalTraversal(root.right,index+1);
		
	}
	
	public void leftView(Node root)
	{
		populateVerticalTraversal(root,0);
		hash.displayFirstLeftElement();
	}
	
}

public class TreeTopViewApp {
	public static void main(String[] args) {
		Node root = new Node(9);
		Node node3 = new Node(3);
		Node node2 = new Node(2);
		Node node1 = new Node(1);
		Node node11 = new Node(11);
		Node node10 = new Node(10);
		Node node8 = new Node(8);
		Node node16 = new Node(16);
		Node node17 = new Node(17);
		Node node19 = new Node(19);
		root.left = node3;
		node3.left = node2;
		node2.left = node1;
		node2.right = node11;

		root.right = node10;
		node10.left = node8;
		node10.right = node16;
		node16.right = node17;
		node17.right = node19;
		Tree tree = new Tree(root);
		tree.leftView(root);


		
	       /*
*          9 
*       3      10  
*    2       8  16
*  1  11           17
*                    19
*        
    [-3] 1 
    [-2] 2 
    [-1] 3
    [0] 9
    [1] 10 
    [2] 16 
    [3] 17 
    [4] 19 

*        
*        
* */		
	}

}
