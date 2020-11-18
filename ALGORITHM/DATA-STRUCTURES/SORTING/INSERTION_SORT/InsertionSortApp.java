/*
2020-Nov-07. Oleksii Saiun.
Merge Sort

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

	public void insertionSort(int[] arr) {
      for(int j=1; j<arr.length;j++)
      {    	      
		  int currIndex=j;
    	  int key=arr[currIndex];
    	  int counter=j-1;
    	  while(counter>=0 && key<arr[counter] )
    	  {
              if (key<arr[counter] )
              {
            	  swap(arr,counter,currIndex);
            	  currIndex=counter;
            	  key=arr[currIndex];
              }
              counter--;
    	  }
      }
	}
	
	public void swap(int[] arr, int index1, int index2)
	{
		int tmp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=tmp;
	}
}

public class InsertionSortApp {
	public static void main(String[] args) {
		MySort my = new MySort();
		int[] arr = new int[]{11,2,3,4,3,3,0,2,1,3,9,3};
		my.displayArray(arr);
		my.insertionSort(arr);
		my.displayArray(arr);

	}

}
