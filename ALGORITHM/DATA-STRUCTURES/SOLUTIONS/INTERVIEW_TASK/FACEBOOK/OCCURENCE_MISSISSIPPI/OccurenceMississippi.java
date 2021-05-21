import java.util.HashMap;

/* 2020-May-21. Oleksii Saiun. Facebook 
 * 
 * count the number of times a character appears in a string   
 *       find s in missisipi
 *
 * 
 * */

class Calc {
	public int countOccurence_approach1(String str, char symbol) {
		int counter = 0;

		for (int j = 0; j < str.length(); j++) {
			if (str.charAt(j) == symbol) {
				counter++;
			}
		}
		return counter;
	}
	
	public int countOccurence_approach2(String str, char symbol) {
        HashMap<Character, Integer> map = new HashMap<>();
		for (int j = 0; j < str.length(); j++) {
			char key = str.charAt(j);
			int freq = map.getOrDefault(key, 0);
			map.put(key, freq+1);
		}
		if(map.containsKey(symbol))
		{
			return map.get(symbol);
		}
		else
		{
			return 0;
		}
	}	
}

public class OccurenceMississippiApp {
	public static void main(String[] args) {
		Calc calc = new Calc();
		String str = "missisipi";
		char symbol = 's';
		int occurence1=calc.countOccurence_approach1(str, symbol);
		int occurence2=calc.countOccurence_approach2(str, symbol);
		System.out.println("occurence1:"+occurence1);
		System.out.println("occurence2:"+occurence2);

	}

}
