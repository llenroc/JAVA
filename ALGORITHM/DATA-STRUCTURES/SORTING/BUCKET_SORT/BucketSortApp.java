import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
2020-Nov-17. Oleksii Saiun.Bucket Sort
*/
class MySort {
	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	public void bucketSort(int[] arr, int bucketSize) {
		// 1. creating buckets
		List<Integer>[] bucket = new ArrayList[bucketSize];
		for (int j = 0; j < bucketSize; j++) {
			bucket[j] = new ArrayList<>();
		}

		// 2. Populate buckets
		for (int j = 0; j < arr.length; j++) {
			int key = arr[j];
			int bucketNumber = getBucket(key, bucketSize);
			bucket[bucketNumber].add(key);
		}
		// 3. Sort buckets
		for (int j = 0; j < bucketSize; j++) {
			Collections.sort(bucket[j]);
		}

		// 3. Merge buckets into an original array
		int index = 0;
		for (int j = 0; j < bucketSize; j++) {
			for (int k = 0; k < bucket[j].size(); k++) {
				arr[index++] = bucket[j].get(k);
			}
		}
	}

	// 2. Populate buckets
	public int getBucket(int key, int bucketSize) {
		return key / bucketSize;
	}
}

public class BucketSortApp {
	public static void main(String[] args) {
		MySort my = new MySort();
		int[] arr = new int[] { 91,99,37, 1, 99, 74, 12, 45, 29, 99, 67, 85, 32, 4, 15, 9, 0, 0, 18,96,55,97 };
		my.displayArray(arr);
		my.bucketSort(arr, 10);
		my.displayArray(arr);
	}

}
