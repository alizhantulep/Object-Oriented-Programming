package problem1;

public class testershape {
	public static void main(String[] args) {
		Cylinder c = new Cylinder(3,4);
		System.out.println(c.volume());
		
		Sphere s = new Sphere(6);
		System.out.println(s.volume());
		
		Cube a = new Cube(4);
		System.out.println(a.volume());
	}
}
