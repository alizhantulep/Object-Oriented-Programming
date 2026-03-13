package problem1;

public class Cylinder extends Shape3D {
	private double radius, height;
	public Cylinder(double r, double h) {
		this.radius = r;
		this.height = h;
	}
	public double volume() {
		return radius * radius * Math.PI * height;
	}
	public double surfaceArea() {
		return 2 * Math.PI * radius * (radius + height);
	}
	
}