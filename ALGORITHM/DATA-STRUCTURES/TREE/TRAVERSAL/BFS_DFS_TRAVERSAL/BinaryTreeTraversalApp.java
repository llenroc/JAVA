import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*2020-Jul-03. Oleksii Saiun
 * Traversal of Binary Tree:
 * 1. DFS: 
 *        pre-order
 *        post-order
 *        in-order
 * 2.BFS       
 * 
 * */
class Node {
    Node left;
    Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

class Tree {
    Node node;

    public Tree(Node node) {
        this.node = node;
    }

//-----------------------------------------------
//1.PreOrder - [recursive]    
    public void preOrderRecursive(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.getValue() + " ");
            preOrderRecursive(root.left);
            preOrderRecursive(root.right);
        }
    }

    // -----------------------------------------------
    // 2.PreOrder - [iterative]
    public void preOrderIterative(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node tmpNode = stack.pop();
            System.out.print(tmpNode.getValue() + " ");
            if (tmpNode.right != null) {
                stack.push(tmpNode.right);
            }
            if (tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
    }

    // -----------------------------------------------
    // 3.InOrder - [recursive]
    public void inOrderRecursive(Node root) {
        if (root == null) {
            return;
        } else {
            inOrderRecursive(root.left);
            System.out.print(root.getValue() + " ");
            inOrderRecursive(root.right);
        }
    }

    // -----------------------------------------------
    // 4.InOrder - [iterative]
    public void inOrderIterative(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack();
        Node tmpNode = root;
        while (!stack.isEmpty() || tmpNode != null) {
            if (tmpNode != null) {
                stack.push(tmpNode);
                tmpNode = tmpNode.left;
            } else {
                tmpNode = stack.pop();
                System.out.print(tmpNode.getValue() + " ");
                tmpNode = tmpNode.right;
            }
        }
    }

    // -----------------------------------------------
    // 5.PostOrder - [recursive]
    public void postOrderRecursive(Node root) {
        if (root == null) {
            return;
        }
        postOrderRecursive(root.left);
        postOrderRecursive(root.right);
        System.out.print(root.getValue() + " ");
    }

    // -----------------------------------------------
    // 6.PostOrder - [iterative]
    // using two stacks
    public void postOrderIterative(Node root) {
        Stack<Node> stack1 = new Stack();
        stack1.push(root);

        Stack<Integer> stack2 = new Stack();

        while (!stack1.isEmpty()) {
            Node tmpNode = stack1.pop();
            stack2.push(tmpNode.getValue());

            if (tmpNode.left != null) {
                stack1.push(tmpNode.left);
            }

            if (tmpNode.right != null) {
                stack1.push(tmpNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop() + " ");
        }
    }

    // -----------------------------------------------
    // 8.BSF - [iterative]
    // using two stacks
    public void BSF_Recursive(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            System.out.print(tmpNode.getValue() + " ");
            if (tmpNode.left != null) {
                queue.offer(tmpNode.left);
            }

            if (tmpNode.right != null) {
                queue.offer(tmpNode.right);
            }

        }
    }

}

public class BinaryTreeTraversalApp {

    public static void main(String[] args) {
        Node root = new Node(9);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node8 = new Node(8);
        Node node16 = new Node(16);
        root.left = node3;
        node3.left = node2;
        node2.left = node1;
        node2.right = node11;

        root.right = node10;
        node10.left = node8;
        node10.right = node16;

        Tree tree = new Tree(root);

        System.out.println("Traversal in PreOrder way [recursive]:");
        tree.preOrderRecursive(root);
        System.out.println();

        System.out.println("Traversal in PreOrder way [iterative]:");
        tree.preOrderIterative(root);
        System.out.println();

        System.out.println("Traversal in InOrder way [recursive]:");
        tree.inOrderRecursive(root);
        System.out.println();

        System.out.println("Traversal in InOrder way [iterative]:");
        tree.inOrderIterative(root);
        System.out.println();

        System.out.println("Traversal in PostOrder way [recursive]:");
        tree.postOrderRecursive(root);
        System.out.println();

        System.out.println("Traversal in PostOrder way [iterative]:");
        tree.postOrderIterative(root);
        System.out.println();

        System.out.println("Traversal in BSF way [recursive]:");
        tree.BSF_Recursive(root);
        System.out.println();

        /*
         *          9 
         *       3      10  
         *    2       8  16
         *  1  11
         *        
         * 
         * */
    }

}
