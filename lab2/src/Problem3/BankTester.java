package Problem3;

public class BankTester {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account acc1 = new Account(1001);                       
        SavingAccount sav1 = new SavingAccount(2001, 5.0);    
        CheckingAccount chk1 = new CheckingAccount(3001); 

        bank.openAccount(acc1);
        bank.openAccount(sav1);
        bank.openAccount(chk1);

        acc1.deposit(500);
        sav1.deposit(1000);
        chk1.deposit(200);

        acc1.withdraw(200);
        sav1.withdraw(100);
        chk1.withdraw(50);

        chk1.deposit(30);
        chk1.withdraw(20);

        System.out.println("\nAccounts BEFORE update:");
        bank.printAllAccounts();

        bank.updateAccounts();

        System.out.println("\nAccounts AFTER update:");
        bank.printAllAccounts();

        bank.closeAccount(6001);

        System.out.println("\nAccounts AFTER closing one account:");
        bank.printAllAccounts();
    }
}