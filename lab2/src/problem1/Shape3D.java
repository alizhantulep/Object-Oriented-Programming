package problem1;

public abstract class Shape3D {
	public abstract double volume();
	public abstract double surfaceArea();
	public String toString() {
		return ("This has a area" + surfaceArea());
	}
}