package Problem4;

public class Resistor extends Circuit {
	private double resistance;
    private double potentialDifference;
    public Resistor(double resistance) {
        this.resistance = resistance;
        this.potentialDifference = 0.0;
    }
    public double getResistance() {
        return resistance;
    }
    public double getPotentialDiff() {
        return potentialDifference;
    }
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
    }
}
