/*
2020-Dec-03. Oleksii Saiun.
LeetCode_#973. K Closest Points to Origin
https://leetcode.com/problems/k-closest-points-to-origin/

time complexity: O(N*Log(K)), where K- largest element, N - length of array
space complexity: O(K)
*/

class Solution {
	private PriorityQueue<int[]> heap = new PriorityQueue<>(
			(arr1, arr2) -> getDistanceToOrigin(arr2[0], arr2[1]) - getDistanceToOrigin(arr1[0], arr1[1]));

	private int getDistanceToOrigin(int x, int y) {
		return (int) (Math.pow(x - 0, 2) + Math.pow(y - 0, 2));
	}

	public int[][] kClosest(int[][] points, int K) {
		int[][] out = new int[K][2];
		int index = 0;
		for (int j = 0; j < points.length; j++) {
			heap.offer(points[j]);

			if (heap.size() > K) {
				heap.poll();
			}
		}

		// populate final output
		while (!heap.isEmpty()) {
			int[] val = heap.poll();
			out[index++] = val;
		}
		return out;
	}
}
