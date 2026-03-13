package Problem3;

public class CheckingAccount extends Account {
	private int numberoftrans;
	private static final int Free = 1;
	private static final double comission = 0.02;
	public CheckingAccount(int accNumber) {
		super(accNumber);
		numberoftrans = 0;
	}
	public void deposit(double sum) {
		super.deposit(sum);
		numberoftrans++;
	}
	public void withdraw(double sum) {
		super.withdraw(sum);
		numberoftrans++;
	}
	public void deductFee() {
		if (numberoftrans > Free) {
			int extra = numberoftrans - Free;
			double fee = extra * comission;
			super.withdraw(fee);
		}
		numberoftrans=0;
	}
	public String toString() {
		 return "CheckingAccount #" + getAccountNumber() + " Balance: $" + getBalance() + " Transactions: " + numberoftrans;
	}
}
