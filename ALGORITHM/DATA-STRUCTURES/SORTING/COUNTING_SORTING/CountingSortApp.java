/*
2020-Nov-07. Oleksii Saiun.
Counting Sort.

The sorting [Counting Sort] works only for positive integers(including 0)

*/
class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public int findMax(int[] arr) {
		int maxVal = arr[0];
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] > maxVal) {
				maxVal = arr[j];
			}
		}
		return maxVal;
	}

	public void countingSort(int[] arrA) {
		// #1.find max value in arrayA
		int maxVal = findMax(arrA);

		// #2.create a new array of length maxVal+1
		int[] arrB = new int[maxVal + 1];

		// #3.populate arrB by frequency of elements from arrayA
		for (int j = 0; j < arrA.length; j++) {
			int valOfA = arrA[j];
			int indexOfB = valOfA;
			arrB[indexOfB] = arrB[indexOfB] + 1;
		}

		// #4. make cumulative array
		int sum = 0;
		for (int j = 0; j < arrB.length; j++) {
			sum = sum + arrB[j];
			arrB[j] = sum;
		}

		// #5. create final array which will contain ordered element
		int arrC[] = new int[arrA.length];

		// #6. populate ordered element
		for (int j = 0; j < arrA.length; j++) {
			int valueOfA = arrA[j];
			int indexOfB = valueOfA;
			int valueOfB = arrB[valueOfA]--; // we increment values for next touch - if there are dups next one will be
												// -1

			int indexOfC = valueOfB - 1;
			int valueOfC = indexOfB;
			arrC[indexOfC] = valueOfC;
		}

		// #7. copy values from a temporary arrC to the original arrA in an ordered way
		for (int j = 0; j < arrA.length; j++) {
			arrA[j] = arrC[j];
		}

	}
}

public class CountingSortApp {
	public static void main(String[] args) {
		int[] arr = new int[] { 4, 2, 9, 4, 7, 6 };
		MySort my = new MySort();
		my.displayArray(arr);
		my.countingSort(arr);
		my.displayArray(arr);
	}

}
