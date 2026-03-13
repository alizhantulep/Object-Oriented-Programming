package problem1;

public class testerc {
	public static void main(String[] args) {
		Toyota c = new Toyota("sedan", 4, 2025, "Camry");
		System.out.println(c.hashCode());
		Toyota e = new Toyota("sedan", 4, 2024, "Camry");
		System.out.println(e.hashCode());
		System.out.println(e.equals(c));
		System.out.println(e.equals(e));
		Car a = new Car("sedan", 4, 2024);
		System.out.println(e.equals(a));
	}
}