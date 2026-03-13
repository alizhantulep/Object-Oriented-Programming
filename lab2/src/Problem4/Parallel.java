package Problem4;

public class Parallel extends Circuit{
	private Circuit c1, c2;
    private double potentialDifference;
    public Parallel(Circuit c1, Circuit c2) {
        this.c1 = c1;
        this.c2 = c2;
    }
    public double getResistance() {
        double R1 = c1.getResistance();
        double R2 = c2.getResistance();
        return 1.0 / (1.0 / R1 + 1.0 / R2);
    }
    public double getPotentialDiff() {
        return potentialDifference;
    }
    public void applyPotentialDiff(double V) {
        this.potentialDifference = V;
        c1.applyPotentialDiff(V);
        c2.applyPotentialDiff(V);
    }
}
