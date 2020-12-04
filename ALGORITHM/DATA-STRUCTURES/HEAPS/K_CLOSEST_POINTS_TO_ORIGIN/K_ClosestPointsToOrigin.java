package heap.k_closest_points_to_origin;

import java.util.PriorityQueue;

/*2020-Dec-04. Oleksii Saiun. 'K' Closest Points to the Origin
 * Task:
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * 
 * 
 * Solution>\:
 * Origin has a coordininates (0,0)
 * Your goal is to calc min distance from points to origin
 * In other words, calc distance and out them in a prority queue
 * 
 * Euclidean distance can be calculated by formula
 * distance = sqrt[ (x2-x1)^2 + (y2-y1)^2] 
 * 
 * Input:
 * { 3, 3 }, { 5, -1 }, { -2, 4 } 
 * Result - lowest distance for K=2 from coordinates below to the origin (0,0):
 * { 3, 3 }
 * { -2, 4 }
 * */
class Calc {
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

	public void printMatrix(int[][] matr) {
		for (int row = 0; row < matr.length; row++) {
			System.out.print("[ ");
			for (int col = 0; col < matr[row].length; col++) {
				System.out.print(matr[row][col] + " ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public void printArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

}

public class K_ClosestPointsToOrigin {
	public static void main(String[] args) {
		Calc calc = new Calc();
		int[][] matr = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		System.out.println("input:");
		calc.printMatrix(matr);
		//call the main method:
		int out[][] = calc.kClosest(matr, k);
		System.out.println("output:");
		calc.printMatrix(out);
		System.out.println();
	}
}
