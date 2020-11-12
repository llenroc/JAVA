/*
2020-Nov-12. Oleksii Saiun.
LeetCode_#283. Move Zeroes
https://leetcode.com/problems/sort-an-array/

Solution:
		// move all not null elements to the left
		// we keep a track for two pointers. The first - current position in array. The second pointer - is a pointer for not 0 values
		// when we moved all not 0 numbers to the left we fill out the rest of array by 0
*/

class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public void moveZeroes(int[] arr) {
		int len = arr.length;
		int index = 0;
		// move all not null elements to the left
		// we also keep a track for two pointers. The second pointer - is a pointer for
		// not 0 values
		// when we moved all not 0 numbers to the left we fill out the rest of array by
		// 0
		for (int k = 0; k < len; k++) {
			if (arr[k] != 0) {
				arr[index++] = arr[k];
			}
		}
		for (int i = index; i < len; i++) {
			arr[i] = 0;
		}
	}

}

public class AppMoveZeros {
	public static void main(String[] args) {
		int[] arr = new int[] { 0, 1, 0, 3, 12 };
		MySort my = new MySort();
		my.displayArray(arr);
		my.moveZeroes(arr);
		my.displayArray(arr);
	}

}
