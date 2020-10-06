/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

/*
2020-Oct-06. Oleksii Saiun.
LeetCode_#426. Convert Binary Search Tree to Sorted Doubly Linked List
https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
*/


class Solution {
    private Stack<Integer> stack = new Stack<>();
    public Node treeToDoublyList(Node root) {
        if(root==null)
		{
			return null;
		}	
        return convert(root);
    }
    
	private void inOrder(Node root)
	{
		if(root==null)
		{
			return;
		}		
		inOrder(root.left);
		stack.push(root.val);
		inOrder(root.right);		
	}
    
	public Node convert(Node root) {
		inOrder(root);

		Node newNode = new Node(stack.pop());

		Node head = newNode;
		Node tail = newNode;
        head.left=tail;
		tail.right=head;

		while (!stack.isEmpty()) {

			newNode = new Node(stack.pop());

			newNode.right = head;
			head.left = newNode;
			head = newNode;
			head.left = tail;
			tail.right = head;

		}
		return head;
	}
    
}
