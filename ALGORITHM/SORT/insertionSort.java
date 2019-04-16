//INSERTION SORT
//2019-Apr-16
class Algorithm
{       
  public void show(int[] arr)
  {
      for(int j=0;j<arr.length;j++)
      {
              System.out.print(arr[j]+" ");
      }
              System.out.println();            
  }
       

 public int[] insertionSort(int[] arr)
 {
   //  int step;  
     int j;
     int key;
     
     //STEP
       for( int step=1; step <= arr.length-1; step++)
       {
         j=step;
         key=arr[j];        

      while(j > 0)  
      {
     if (arr[j-1]>key)
     {
         int tmp = arr[j-1];                  
         arr[j-1] = key;
         arr[j] = tmp;
         //set up a new value for key - move left on 1 position
         key = arr[j-1];
     }
      }

       }
     return arr;
 }
    
    
}  
public class MainClass {
    public static void main(String[] args) {
    Algorithm algor = new Algorithm();
        int [] arr = new int[]{15,4,3,1,0};
    algor.show(arr);
    int[] sortedArr = algor.insertionSort(arr);
    System.out.println ("-----------");
    algor.show(sortedArr);
    }
}
