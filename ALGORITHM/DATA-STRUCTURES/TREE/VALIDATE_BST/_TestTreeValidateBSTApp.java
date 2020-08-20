import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class _TestTreeValidateBSTApp {

	
	private Node buildTree1()
	{
        /*
         *           5 
         *         /   \   
         *        3     8
         *      /  \   /  \
         *     2    4  6   10
         *     
         *                  
         */
		Node root = new Node(5);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		Node node8 = new Node(8);
		Node node10 = new Node(10);

		root.left = node3;
		node3.left = node2;
		node3.right = node4;
		root.right = node8;
		node8.left = node6;
		node8.right = node10;
		
		return root;
	}
	
	private Node buildTree2()
	{
        /*
         *           5 
         *         /   \   
         *        1     4
         *             /  \
         *             3   6
         *                        
         */
		
		Node root = new Node(5);
		Node node1 = new Node(1);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node6 = new Node(6);
		
		root.left=node1; 
		root.right=node4; 
		node4.left=node3; 
		node4.right=node6;
		
		return root;
	}
	
	@Test
	public void testIsBSTValid1()
	{
		Node rootInput = buildTree1();
		Tree tree = new Tree(rootInput);
		assertEquals(tree.isValidBST(rootInput), true);
	}
	
	@Test
	public void testIsBSTValid2()
	{
		Node rootInput = buildTree2();
		Tree tree = new Tree(rootInput);
		assertEquals(tree.isValidBST(rootInput), false);
	}
	
	@Test
	public void testIsBSTValidNull()
	{
		Node rootInput = null;
		Tree tree = new Tree(rootInput);
		assertEquals(tree.isValidBST(rootInput), true);
	}
}
