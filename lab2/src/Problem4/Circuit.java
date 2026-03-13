package Problem4;

public abstract class Circuit {
	public abstract double getResistance();
	public abstract double getPotentialDiff();
	public abstract void applyPotentialDiff(double V);
	public double getPower() {
	// my  code
		double V = getPotentialDiff();
		return V * V / getResistance();
	}
	public double getCurrent() {
		double V = getPotentialDiff();
        return V / getResistance();
	// my code
	}
}
