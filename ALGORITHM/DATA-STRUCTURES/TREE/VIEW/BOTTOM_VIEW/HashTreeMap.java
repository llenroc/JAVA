import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

import java.util.TreeMap;
import java.util.Deque;

public class HashTreeMap {

	Map<Integer, Deque<Node>> map;

	public Map<Integer, Deque<Node>> getMap() {
		return map;
	}

	public HashTreeMap() {
		map = new TreeMap<>();
	}

	public void addValue(int index, Node node) {

		if (!map.containsKey(index)) {
			Deque<Node> dequeuNew = new LinkedList<>();
			dequeuNew.addFirst(node);
			map.put(index, dequeuNew);
		} else {
			Deque<Node> dequeuExisting = map.get(index);
			dequeuExisting.addFirst(node);
		}
	}

	public void displayFirstRightElement() {
		for (Entry<Integer, Deque<Node>> entry : map.entrySet()) {
			int index = entry.getKey();
			Deque<Node> dequeu = entry.getValue();
			System.out.print("[" + index + "] ");
			displayDequeFirstElement(dequeu);
			System.out.println();
		}
	}

	private void displayDequeFirstElement(Deque<Node> dequeu) {
			dequeu.removeFirst().displayValue();
	}
}
