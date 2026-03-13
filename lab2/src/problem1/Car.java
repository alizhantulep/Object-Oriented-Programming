package problem1;

public class Car {
	private String type;
	private int year, numofdoor;
	public Car(String type, int numofdoor, int year) {
		this.type = type;
		this.numofdoor = numofdoor;
		this.year= year;
	}
	public String gettype() {
		return type;
	}
	public int getnumofdoor() {
		return numofdoor;
	}
	public int getyear() {
		return year;
	}
	public void setyear(int newyear) {
		year = newyear;
	}
	public void setnumofdoor(int numof) {
		numofdoor = numof;
	}
	public void settype(String typ) {
		type = typ;
	}
	public String toString() {
		return ("Type: " + type + "Num of doors: " + numofdoor + "Year:" + year);
	}
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null || o.getClass() != getClass()) {
			return false;
		}
		Car other = (Car) o;
		return year == other.year &&
				type.equals(other.type)&&
				numofdoor == other.numofdoor;
	}
	public int hashCode() {
		int result = 17;
		result = 31 * result + year;
		result = 31 * result + numofdoor;
		result = 31 * result + type.hashCode();
		return result;
	}
}
