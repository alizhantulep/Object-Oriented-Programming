
package problem1;

public class Sphere extends Shape3D{
	private double radius;
	public Sphere(double r) {
		this.radius = r;
	}
	public double volume() {
		return Math.PI * radius * radius * radius * 4 / 3;
	}
	public double surfaceArea() {
		return 4 * Math.PI * this.radius * this.radius;
	}
}