/*
2020-Nov-16. Oleksii Saiun.
Radix Sort.

*/

class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	// 1. Radix Sort
	public void radixSort(int[] arr) {
		int maxVal = findMax(arr);
		int stepOfDigit = 1;
		//we find max value and then creates steps [1,10,100,...]
		//It means we sort digit by digit from right to left
		/*For example, maxVal=789
		 * 
		 * stepOfDigit[1]   = consider [9]
		 * stepOfDigit[10]  = consider [8]
		 * stepOfDigit[100] = consider [7]
		 * 
		 * */
		for (int j = maxVal; j > 0; j = j / 10) {
			countingSort(arr, stepOfDigit);
			stepOfDigit = stepOfDigit * 10;
		}
	}

	// 2. Counting Sort
	private void countingSort(int arrA[], int stepOfDigit) {
		{
			// #1.create a new array of length maxVal+1
			int[] arrB = new int[10];

			// #2.populate arrB by frequency of elements from arrayA
			for (int j = 0; j < arrA.length; j++) {
				int valOfA = (arrA[j] / stepOfDigit) % 10;
				int indexOfB = valOfA;
				arrB[indexOfB] = arrB[indexOfB] + 1;
			}

			// #3. make cumulative array
			int sum = 0;
			for (int j = 0; j < arrB.length; j++) {
				sum = sum + arrB[j];
				arrB[j] = sum;
			}

			// #4. a create final array which will contain ordered element
			int arrC[] = new int[arrA.length];
			displayArray(arrB);
			// #5. populate ordered element
			//(!) it is super IMPORTANT. I traverse array visa verse - otherwise, result is not correct in my program
			for (int j = arrA.length - 1; j >= 0; j--) {
				int valueOfA = arrA[j];
				int valueOfABucket = (valueOfA / stepOfDigit) % 10;
				// int indexOfB = valueOfABucket;
				int indexOfB = valueOfA;

				int valueOfB = arrB[valueOfABucket]--; // we increment values for next touch - if there are dups next
														// one will be
														// -1

				//
				int indexOfC = valueOfB - 1;
				int valueOfC = indexOfB;
				System.out.println(
						"indexOfB:" + indexOfB + "; " + valueOfB + "; indexOfC:" + indexOfC + "; valueOfC:" + valueOfC);
				arrC[indexOfC] = valueOfC;
			}

			// #6. copy values from a temporary arrC to the original arrA in an ordered way
			for (int j = 0; j < arrA.length; j++) {
				arrA[j] = arrC[j];
			}
		}
	}


	private int findMax(int[] arr) {
		int maxVal = arr[0];
		for (int j = 1; j < arr.length; j++) {
			if (arr[j] > maxVal) {
				maxVal = arr[j];
			}
		}
		return maxVal;
	}

}

public class RadixSortApp {
	public static void main(String[] args) {
		int[] arr = new int[] { 10, 15, 1, 60, 5, 100, 25, 50 };
		MySort my = new MySort();
		my.displayArray(arr);
		my.radixSort(arr);
		my.displayArray(arr);

	}

}
