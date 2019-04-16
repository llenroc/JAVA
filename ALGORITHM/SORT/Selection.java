//SELECTION SORT
//2019-Apr-10
class Algorithm
{   
    
  public  void show(int[] arr)
  {
      for(int j=0;j<arr.length;j++)
      {
              System.out.print(arr[j]+" ");
      }
              System.out.println();
            
  }
    
 public int[] sortSelect(int[] arr )
 {
          int positionStart = 0;
     while (positionStart <arr.length  )
     {

     int min_value = arr[positionStart];
     int min_index = positionStart;
     
 //find min:
        for(int j=positionStart;j<arr.length;j++)
       {
               if (min_value > arr[j])
               {
                   min_index=j;
                   min_value=arr[j];                   
               }                             
       }
 // swap:
     int tmp_val = arr[min_index];
     arr[min_index] = arr[positionStart];
     arr[positionStart] = tmp_val;
// incerement
         positionStart = positionStart +1;
         
     }
   return arr;
 }    
}  
public class MainClass {
    public static void main(String[] args) {
    Algorithm algor = new Algorithm();
        int [] arr = new int[]{5,4,3,10,2,1};
    algor.show(arr);
    int[] sortedArr =algor.sortSelect(arr);
    algor.show(sortedArr);
        
    }
}