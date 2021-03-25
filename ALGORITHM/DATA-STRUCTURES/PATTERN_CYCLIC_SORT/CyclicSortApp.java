class Calc {

	public int[] cyclicSort(int[] arr) {

		for (int j = 0; j < arr.length; j++) {
			cyclicSwap(arr,j);
		}

		return arr;
	}

	public void displayArray(int[] arr) {
		for (int j : arr) {
			System.out.print(j + " ");
		}
		System.out.println();
	}

	private void cyclicSwap(int[] arr, int index) {
	   int index1=index;
	   int indexOfSwap=arr[index];
	   
	   while(index1!=indexOfSwap)
	   {
		   swap(arr,index1,indexOfSwap);
		   indexOfSwap=arr[index1];
	   }
	}
	private void swap(int[] arr, int index1, int index2) {
			int tmp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = tmp;
	}
}

public class CyclicSortApp {
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 6, 4, 3, 1, 5, 0 };
		Calc calc = new Calc();
		calc.displayArray(arr);
		int[] sortedArr = calc.cyclicSort(arr);
		calc.displayArray(sortedArr);

	}

}
