import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/*2020-Dec-09. Oleksii Saiun. Reorganize String
 * Leetcode. 767. Reorganize String
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
   Input: Programming
   Output: rgmgrmPiano
 * */

class My {
	private HashMap<Character, Integer> map = new HashMap<>();
	private PriorityQueue<Character> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));

	public String reorganizeString(String s) {
		populateMap(s);
		populateHeap();
		System.out.println("map:" + map);
		System.out.println("heap:" + heap);
		StringBuilder strOut = new StringBuilder();

		while (heap.size() >= 2) {
			// 1. (!) pay attention it completely removes from priority queue row
			Character firstElement = heap.poll();
			Character secondElement = heap.poll();

			strOut.append(firstElement);
			strOut.append(secondElement);

			// 2. update changes in a hashmap
			int freqOfFirstElem = map.get(firstElement) - 1;
			int freqOfSecondElement = map.get(secondElement) - 1;

			map.put(firstElement, freqOfFirstElem);
			map.put(secondElement, freqOfSecondElement);

			// 3. if there is a frequency >0 we need put it back in PriorityQueue to use for
			// a concatination of string
			if (map.get(firstElement) > 0) {
				heap.offer(firstElement);
			}

			if (map.get(secondElement) > 0) {
				heap.offer(secondElement);
			}

		}

		if (!heap.isEmpty()) {
			Character lastElem = heap.poll();
			if (map.get(lastElem) > 1) {
				// it means will be repeating characters
				return "";
			} else {
				// add to the end of a string if there is only one element with one frequency
				strOut.append(lastElem);
			}
		}

		return String.valueOf(strOut);

	}

	private void populateMap(String s) {
		for (int j = 0; j < s.length(); j++) {
			Character key = s.charAt(j);
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq + 1);

		}
	}

	private void populateHeap() {
		for (Entry<Character, Integer> j : map.entrySet()) {
			heap.offer(j.getKey());
		}
	}

	public void displayMap() {
		for (Entry<Character, Integer> j : map.entrySet()) {
			System.out.println("[" + j.getKey() + "; " + j.getValue() + "]");
		}
		System.out.println();
	}
}

public class ReorganizeStringApp {
	public static void main(String[] args) {
		My my = new My();
		String s = "Programming";
		System.out.println("input: "+s);
		String outStr = my.reorganizeString(s);
		System.out.println("output: "+outStr);

	}

}
