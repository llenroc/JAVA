//INSERTION SORT
//2019-Apr-10
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
     int step;
     int j;
     int key;
     
     //STEP
     step = 1;
     j=0;
     key=arr[step-1];        

     while(j < step)
     {
         
     if (key>arr[j+1])
     {
         int tmp = arr[j+1];         
         key = arr[j];
         arr[j] = tmp;
         arr[j+1] = key;
     }
         System.out.println ("inside loop:"+step+"."+j+"; key="+key);
       j++;
     }
       show(arr);
     
     //STEP
     step = 2;
     j=0;
     key=arr[step-1];        

     while(j < step)
     {
         
     if (key>arr[j+1])
     {
         int tmp = arr[j+1];         
         key = arr[j];
         arr[j] = tmp;
         arr[j+1] = key;
     }
         System.out.println ("inside loop:"+step+"."+j+"; key="+key);
       j++;
     }     
     show(arr);
     
     return arr;
 }
     //STEP

    
    
}  
public class MainClass {
    public static void main(String[] args) {
    Algorithm algor = new Algorithm();
        int [] arr = new int[]{15,4,3,1,0};
    algor.show(arr);
    int[] sortedArr = algor.insertionSort(arr);
    algor.show(sortedArr);
    }
}
