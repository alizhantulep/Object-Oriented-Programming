package problem1;

public class Toyota extends Car {
	private String model;
	public Toyota(String type, int numofdoor, int year, String model) {
		super(type,numofdoor,year);
		this.model = model;
	}
	
	public boolean equals(Toyota Camry) {
		if (Camry == this) {
			return true;
		}
		if (!(Camry instanceof Toyota)) {
			return false;
		}
		Toyota other = (Toyota) Camry;
		return super.equals(other) &&
				model.equals(other.model);
	}
		
	public int hashCode() {
		return super.hashCode() + 31 * model.hashCode();
	}
}
