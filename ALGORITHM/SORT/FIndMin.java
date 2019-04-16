class Algorithm
{
  public static void show(int[] arr)
  {
      for(int j=0;j<arr.length;j++)
      {
              System.out.print(arr[j]+" ");
      }
              System.out.println();
  }
    
 public int findMin(int[] arr)
 {
     int min = arr[0];
        for(int j=1;j<arr.length;j++)
      {
               if (min > arr[j])
               {
                   min=arr[j];
               }        
      }
   return min;
 }
    
}
public class MainClass {
    public static void main(String[] args) throws IOException {
    Algorithm algor = new Algorithm();
    int [] arr = new int[]{5,0,4,3,2,8,7,-1,4,-110,100};
    algor.show(arr);
    System.out.println("min: "+algor.findMin(arr));
    }
}
