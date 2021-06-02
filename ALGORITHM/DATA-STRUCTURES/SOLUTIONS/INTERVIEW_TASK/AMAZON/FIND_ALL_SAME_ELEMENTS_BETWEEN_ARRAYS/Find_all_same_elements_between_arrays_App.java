import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*2021-June-01. Oleksii Saiun. Amazon
 * 
 * Identify the common elements within them
Input : A[] : {3, 2, 1} B[] : {1, 4, 2} Output : {1, 2}
Input : A[] : {8, 0, 3, 5, 6, 7,6,6} B[] : {4, 2, 5, 1, 6 , 7, 8, 6} Output : {8,5,6,7,6}
 * */
class Calc {
	
	public int[] findCommonElements(int[] arr1, int[] arr2) {
         List<Integer> list = new ArrayList<>();
         Map<Integer, Integer> map =  populateMapForArray1(arr1);
         
		for (int j = 0; j < arr2.length; j++) {
			int key=arr2[j];
			if(map.containsKey(key))
			{
				list.add(key);
				
				int freqOfkey1=map.get(key);
				if(freqOfkey1==1)
				{
					map.remove(key);
				}
				else
				{
					map.put(key, freqOfkey1-1);
				}				
			}
		}


		int[] outArr = new int[list.size()];
		for(int j = 0; j < list.size(); j++)
		{
			outArr[j]=list.get(j);
		}
		return outArr;
	}

	private Map<Integer, Integer> populateMapForArray1(int[] arr1) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int j = 0; j < arr1.length; j++) {
			int key = arr1[j];
			int currFreq = map.getOrDefault(key, 0);
			map.put(key, currFreq + 1);
		}
		
		return map;
	}

	public void displayArray(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}
}

public class find_all_same_elements_between_arrays_App {

	public static void main(String[] args) {
		Calc calc = new Calc();
		int[] arr1 = new int[] { 8, 0, 3, 5, 6, 7, 6, 6 };
		int[] arr2 = new int[] { 4, 2, 5, 1, 6, 7, 8, 6 };

		int[] out = calc.findCommonElements(arr1, arr2);
		
		calc.displayArray(arr1);
		calc.displayArray(arr2);
		calc.displayArray(out);

	}

}
