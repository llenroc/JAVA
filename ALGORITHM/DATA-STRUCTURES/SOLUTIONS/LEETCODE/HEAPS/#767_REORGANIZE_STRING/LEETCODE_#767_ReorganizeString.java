/*
2020-Dec-09. Oleksii Saiun.
LeetCode_#767. Reorganize String
https://leetcode.com/problems/reorganize-string/
*/

import java.util.Map.*;

class Solution {
    private HashMap<Character, Integer> map = new HashMap<>();    
    private PriorityQueue<Character> heap = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
    
	public String reorganizeString(String s) {
		populateMap(s);
		populateHeap();
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
}
