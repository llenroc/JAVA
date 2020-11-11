/*
2020-Nov-11. Oleksii Saiun.
Shell Sort

Time complexity: 

Space complexity:

*/

class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public void shellSort(int[] arr) {
		int len = arr.length;
		for (int gap = len / 2; gap > 0; gap = gap / 2) {
			System.out.println("---gap(step):" + gap);
			for (int i = 0; i < gap; i++) {
				{
					for (int j = i; j < len; j = j + gap) {
						insertionSort(arr, j);
					}
				}
			}
		}
	}

	public void insertionSort(int[] arr, int index) {
		int k = index;
		while (k >= 1) {
			if (arr[k - 1] > arr[k]) {
				swap(arr, k - 1, k);
			}
			k--;
		}
	}

	public void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

}

public class ShellSortApp {
	public static void main(String[] args) {
		int[] arr = new int[] { 7, 13, 18, 22, 8, 29, 14, 7, 27, 25, 3 };

		MySort my = new MySort();
		my.displayArray(arr);
		my.shellSort(arr);
		my.displayArray(arr);

	}

}
