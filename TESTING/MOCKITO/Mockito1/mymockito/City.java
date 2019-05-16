package mymockito;

public class Application {

	public static void main(String[] args) {
		Street street = new Street("Museum");
		City city = new City(street);

		System.out.println(city.displayBuilding());
	}

}
