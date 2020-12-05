/*
2020-Dec-05. Oleksii Saiun.
LeetCode_#347. Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/
*/


import java.util.Map.Entry;

class Solution {
	private HashMap<Integer, Integer> map = new HashMap<>();
	private PriorityQueue<Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
			(o1, o2) -> o1.getValue() - o2.getValue());

	public int[] topKFrequent(int[] arr, int k) {
		int[] out = new int[k];
		int index = 0;
		populatehashMap(arr);

		for (Entry<Integer, Integer> j : map.entrySet()) {
			minHeap.offer(j);
			while (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		while (!minHeap.isEmpty()) {
			out[index++] = minHeap.poll().getKey();
		}

		return out;
	}

	private void populatehashMap(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			int key = arr[j];
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq + 1);
		}
	}
}
