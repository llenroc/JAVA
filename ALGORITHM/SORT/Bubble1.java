class Data
{
    public void print(int[] arr)
    {
        for(int j=0;j<arr.length;j++)
        {
          System.out.print(arr[j]+" ");
        }
          System.out.println();        
    }
    
        public int[]  sort(int[] arr)
    {
        
       for (int k=0;k<arr.length;k++)
        {
          for(int j=1;j<arr.length;j++)
          {
            if (arr[j-1]>arr[j])
            {
                int tmp = arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=tmp;
            }
          }
        
      }
        return arr;
    }
    
}
public class Bubble1{
     public static void main(String []args){
        Data d = new Data();
        int arr[]={71,11,3,4,-2,8,7,-5,0,0,100,0};
        d.print(arr);
        d.sort(arr);

        d.print(arr);
     }
}