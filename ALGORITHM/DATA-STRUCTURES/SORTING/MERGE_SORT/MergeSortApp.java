/*
2020-Nov-04. Oleksii Saiun.
Merge Sort

Time complexity: 
O(n) = nlog(n) - worst case
Zeta(n) = nlog(n) - average case
Omega(n) = nlog(n) - best case
Space complexity: O(n)

*/   

class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}


	public void mergeSort(int[] arr) {
		split(arr);
	}
	private void split(int[] arr) {
		int length = arr.length;
		
		if (arr.length < 2) {
			return;
		}
		
		int mediumPosition = (length) / 2;
		int[] arrLeft = new int[mediumPosition];
		int[] arrRight = new int[length - mediumPosition];

		int k = 0; // counter for the second array when we fill after medium
		for (int i = 0; i < length; i++) {
			if (i < mediumPosition) {
				arrLeft[i] = arr[i];
			} else {
				arrRight[k++] = arr[i];
			}
		}

		split(arrLeft);
		split(arrRight);
		mergeArrays(arr, arrLeft, arrRight);
	}

	private void mergeArrays(int[] arr, int[] arrLeft, int[] arrRight) {
		int counter = 0; // counter of main array arr
		int counterOfLeftArr = 0; // counter of left array
		int counterOfRightArr = 0; // counter of left array

		while (counterOfLeftArr < arrLeft.length && counterOfRightArr < arrRight.length) {
			if (arrLeft[counterOfLeftArr] < arrRight[counterOfRightArr]) {
				arr[counter++] = arrLeft[counterOfLeftArr++];
			} else {
				arr[counter++] = arrRight[counterOfRightArr++];
			}
		}
		while (counterOfLeftArr < arrLeft.length) {
			arr[counter++] = arrLeft[counterOfLeftArr++];
		}

		while (counterOfRightArr < arrRight.length) {
			arr[counter++] = arrRight[counterOfRightArr++];
		}
	}

}

public class MergeSortApp {
	public static void main(String[] args) {
		int[] arr = new int[] { 12, 11, 13, 5, 6, 7, 9 };
		MySort mySort = new MySort();
		mySort.displayArray(arr);
		mySort.mergeSort(arr);
		mySort.displayArray(arr);

	}

}
