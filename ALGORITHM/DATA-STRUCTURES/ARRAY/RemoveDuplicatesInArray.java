//REMOVE DUPLICATES IN ARRAY
//2019-Apr-10
class Algorithm
{   
    
  public  void show(Integer[] arr)
  {
      for(int j=0;j<arr.length;j++)
      {
              if( arr[j] != null)
              {
              System.out.print(arr[j]+" ");                  
              }

      }
              System.out.println();
            
  }
    
     public Integer[] removeDuplicates(Integer[] arr)
  {
         Integer element;
       //  Integer index;
         
         
         for(Integer index=0; index < arr.length-1; index++ )
         {
         element=arr[index];
         for (Integer j=index; j<arr.length-1; j++)
         {
                   if (element == arr[j+1])
                   {
                    arr[j+1]=null;
                   }
         }
         }
         return arr;  
  }
}  
public class MainClass {
    public static void main(String[] args) {
    Algorithm algor = new Algorithm();
        Integer [] arr = new Integer[]{5,5,4,3,10,1,2,1,5,5,1,2,4,7,5};
        algor.show(arr);
        Integer [] arrOut = algor.removeDuplicates(arr);
        algor.show(arr);

     //   algor.show(arrOut);

        
    }
}