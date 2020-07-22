/*
 * 2020-Jul-21. Oleksii Saiun
 * Creating HashTable based on LinkedList Generic
 * */

public class HashTableGenericApp {
	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");

		HashTable hash = new HashTable(15);
		hash.insert(0, nodeA);
		hash.insert(0, nodeB);
		hash.insert(0, nodeC);

		hash.insert(1, nodeD);
		hash.insert(1, nodeE);
		hash.insert(1, nodeF);

		hash.insert(3, nodeG);

		hash.insert(4, nodeC);
		hash.insert(4, nodeD);
		hash.insert(5, nodeE);
		hash.displayAll(); 
	}

}
