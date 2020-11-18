/*
2020-Nov-07. Oleksii Saiun.
Selection Sort

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
	
	public void selectionSort(int[] arr)
	{
		for(int k=1; k<arr.length;k++)
		{
		int minElem=arr[k-1];
		int indexOfMin=k-1;
		
		for(int j = k; j<arr.length;j++)
		{
	
			if (minElem>arr[j])
			{
				minElem=arr[j];
				indexOfMin=j;
			}
		}
		System.out.println("min j:"+indexOfMin+"; minElem:"+minElem+";");
		if(arr[k-1]>minElem)
		{
			//swap
			swap(arr,k-1,indexOfMin);
		}
		}
	}
	
	public void swap(int[] arr, int index1, int index2)
	{
		int tmp = arr[index1];
		 arr[index1]= arr[index2];
		 arr[index2]=tmp;
		 
	}
}
public class SelectionSortApp {
	public static void main(String[] args) {
		MySort my = new MySort();
		int[] arr = new int[]{9,8,7,6,5,0,0,1,2,3,4,5};
		my.displayArray(arr);
		my.selectionSort(arr);
		my.displayArray(arr);

	}

}
