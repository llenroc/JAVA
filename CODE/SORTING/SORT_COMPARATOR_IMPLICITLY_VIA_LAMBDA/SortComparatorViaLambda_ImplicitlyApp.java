import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
 * Oleksii Saiun. 2020-Dec-01. Sorting using Lambda expression (explicit comparator)
 *  
 * */

public class SortLambdaApp {
	public static void main(String[] args) {
		Employee emp1 = new Employee("Oleksii","Saiun",34,5000);
		Employee emp2 = new Employee("Susan","Park",70,800);
		Employee emp3 = new Employee("Chris","Zelmon",50,9000);
		Employee emp4 = new Employee("Anna","Boss",29,4800);
		Employee emp5 = new Employee("Alex","Johnson",49,5000);
		Employee emp6 = new Employee("Anna","Peterson",19,2300);
		Employee emp7 = new Employee("Maks","Skliness",30,3500);
		Employee emp8 = new Employee("Junioer","Kstezy",34,5000);
		Employee emp9 = new Employee("Palm","Cheerleston",34,1200);
		Employee emp10 = new Employee("Tanya","Shwarz",32,6500);

		List<Employee> list = new ArrayList<>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);
		list.add(emp5);
		list.add(emp6);
		list.add(emp7);
		list.add(emp8);
		list.add(emp9);
		list.add(emp10);
	
		//Sorting options. Explicit comparator
		
		Comparator <Employee> comparatorAgeDesc = (Employee e1, Employee e2) -> e2.getAge() - e1.getAge();
		Comparator <Employee> comparatorLastNameAsc = (Employee e1, Employee e2) -> e1.getLastName().compareTo(e2.getLastName());
		Comparator <Employee> comparatorSalaryDesc = (Employee e1, Employee e2) -> e2.getSalary() - e1.getSalary();
		
		list.sort(comparatorSalaryDesc);
		
		for(Employee emp : list)
		{
			System.out.println(emp);
		}

	}

}
