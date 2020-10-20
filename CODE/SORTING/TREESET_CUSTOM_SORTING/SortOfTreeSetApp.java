import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
 * Oleksii Saiun. 2020-Oct-20. Sorting of TreeSet by descending order
 *  
 * */

class CustomSortDesc implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}

public class SortOfTreeSetApp {
	public static void main(String[] args) {
		CustomSortDesc customSortDesc = new CustomSortDesc();
		Set<Integer> myset = new TreeSet<>(customSortDesc);
		myset.add(80);
		myset.add(20);
		myset.add(60);
		myset.add(20);
		myset.add(5);
		myset.add(10);
		myset.add(20);
		myset.add(30);
		myset.add(40);
		myset.add(12);
		myset.forEach((x) -> System.out.println(x));

	}
}
