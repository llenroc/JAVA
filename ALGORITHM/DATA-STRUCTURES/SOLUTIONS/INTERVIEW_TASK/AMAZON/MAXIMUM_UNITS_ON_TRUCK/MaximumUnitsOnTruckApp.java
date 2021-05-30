import java.util.PriorityQueue;

/*
2021-May-30. Oleksii Saiun.
LeetCode_#1710. Maximum Units on a Truck
https://leetcode.com/problems/maximum-units-on-a-truck/

Return the maximum total number of units that can be put on the truck.
Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
Output: 8

Solution:
The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.

*/

class Calc {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		PriorityQueue<int[]> maxHeap = buildMaxHeap(boxTypes);
		int remainingSize = truckSize;
		int totalOfUnits = 0;

		while (!maxHeap.isEmpty()) {
			if (remainingSize == 0) {
				return totalOfUnits;
			}
			int[] currValue = maxHeap.poll();
			int currNumberOfBoxes = currValue[0];
			int currNumberOfUnits = currValue[1];
			if (remainingSize >= currNumberOfBoxes) {
				remainingSize = remainingSize - currNumberOfBoxes;
				int currAmount = currNumberOfBoxes * currNumberOfUnits;
				totalOfUnits = totalOfUnits + currAmount;
			} else {

				int currAmount = remainingSize * currNumberOfUnits;
				totalOfUnits = totalOfUnits + currAmount;
				remainingSize = 0;
			}

		}
		return totalOfUnits;
	}

	private PriorityQueue<int[]> buildMaxHeap(int[][] boxTypes) {
		PriorityQueue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		for (int j = 0; j < boxTypes.length; j++) {
			int[] currValue = new int[] { boxTypes[j][0], boxTypes[j][1] };
			maxHeap.add(currValue);
		}

		return maxHeap;
	}
}

public class MaximumUnitsOnTruckApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[][] boxTypes = new int[][] { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;
		System.out.println(calc.maximumUnits(boxTypes, truckSize));
	}

}
