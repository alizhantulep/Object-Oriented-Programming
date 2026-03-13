package Problem3;

public class Account {
	private double balance;
	private int accNumber;
	public Account(int a) {
		balance = 0.0;
		accNumber = a;
	}
	public void deposit(double sum) {
		if (sum > 0) {
			balance = sum + balance;
			System.out.println("Successfully!");
		} else {
			System.out.println(("Incorrect"));
		}
	}
	public void withdraw(double sum) {
			if (sum > 0 && sum <= balance) {
				balance = balance - sum;
			} else {
				System.out.println("Incorrect");
			}
	}
	public double getBalance() {
		return balance;
		
	}
	public int getAccountNumber() {
		return accNumber;
		
	}
	public void transfer(double amount, Account other) {
		if (amount > 0 && amount <= balance) {
			this.withdraw(amount);
			other.deposit(amount);
		} 
		else {
			System.out.println("Incorrect");
		}
		
	}
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		else if (!(other instanceof Account)){
			return false;
		}
		else {
			Account newother = (Account) other;
			return this.accNumber == newother.accNumber;
		}
	}
	public String toString() {
		 return "Account #" + accNumber + " Balance: $" + balance;
		
	}
	public final void print() {
		System.out.println(toString());
	}
}
