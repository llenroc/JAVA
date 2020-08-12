import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

public class MyHashMap {

	HashMap<Integer, LinkedList<Node>> hashmap;

	public MyHashMap() {
		hashmap = new HashMap<>();
	}

	public void insert(int index, Node node) {
		if (!hashmap.containsKey(index)) {
			LinkedList<Node> list = new LinkedList<>();
			list.add(node);
			hashmap.put(index, list);
		} else {
			LinkedList<Node> tmpList = hashmap.get(index);
			tmpList.add(node);
		}
	}

	public void displayList(LinkedList<Node> tmpList) {
		while (!tmpList.isEmpty()) {
			System.out.print(tmpList.removeFirst().getValue() + " ");
		}
	}
	
	public int calcSumOfList(LinkedList<Node> tmpList) {
		int sum=0;
		while (!tmpList.isEmpty()) {
			sum=sum+tmpList.removeFirst().getValue();
		}
		return sum;
	}
	

	public void displayAll() {
		for (Entry<Integer, LinkedList<Node>> j : hashmap.entrySet()) {
			LinkedList<Node> tmpList = j.getValue();
			System.out.print(j.getKey() + ": ");
			displayList(tmpList);
			System.out.println();
		}
	}
	
	public void displaySumOfAll() {
		for (Entry<Integer, LinkedList<Node>> j : hashmap.entrySet()) {
			LinkedList<Node> tmpList = j.getValue();
			System.out.print(j.getKey() + ": "+calcSumOfList(tmpList));
			System.out.println();
		}
	}
}
