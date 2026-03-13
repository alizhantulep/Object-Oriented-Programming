package problem1;

public class Cube extends Shape3D {
	private double edge;
	public Cube(double h) {
		this.edge = h;
	}
	public double surfaceArea() {
		return edge * edge * 6;
	}
	public double volume() {
		return edge * edge * edge;
	}
}