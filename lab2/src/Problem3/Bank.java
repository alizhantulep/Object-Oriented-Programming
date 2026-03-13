package Problem3;

import java.util.Vector;

public class Bank {
    private Vector<Account> accounts;

    public Bank() {
        accounts = new Vector<>();
    }

    public void openAccount(Account acc) {
        accounts.add(acc);
        System.out.println("Account opened: " + acc.getAccountNumber());
    }

    public void closeAccount(int accNumber) {
    boolean b=	accounts.remove(new Account(accNumber));
    
    if(b) {
    	System.out.println("Account closed: " + accNumber);
    }
    else {
    	System.out.println("Account not found " + accNumber);
    }
    	
    }

    public void updateAccounts() {
        for (Account acc : accounts) {
            if (acc instanceof SavingAccount) {
                ((SavingAccount) acc).addInterest();
            }
            if (acc instanceof CheckingAccount) {
                ((CheckingAccount) acc).deductFee();
            }
        }
    }

    public void printAllAccounts() {
        for (Account acc : accounts) {
            acc.print();
        }
    }
}