package Problem3;

public class SavingAccount extends Account {
	 private double interestRate;
	 public SavingAccount(int accNumber, double interesRate) {
		 super(accNumber);
		 this.interestRate = interesRate;
	 }
	 
	 public void addInterest() {
		 double interest = getBalance()*(interestRate/100);
		 deposit(interest);
	 }
	 public String toString() {
	        return "SavingsAccount #" + getAccountNumber() + " | Balance: $" + getBalance() + 
	               " | Interest Rate: " + interestRate + "%";
	 }
}
