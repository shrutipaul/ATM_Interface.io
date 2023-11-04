import java.util.*;

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public double checkBalance() {
        return balance;
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Quit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Please select an option (1/2/3/4): ");
            String choice = scanner.next();

            if (choice.equals("1")) {
                System.out.print("Enter the amount to withdraw: ");
                double amount = scanner.nextDouble();
                if (bankAccount.withdraw(amount)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
                }
            } else if (choice.equals("2")) {
                System.out.print("Enter the amount to deposit: ");
                double amount = scanner.nextDouble();
                if (bankAccount.deposit(amount)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Deposit failed. Please enter a valid amount.");
                }
            } else if (choice.equals("3")) {
                double balance = bankAccount.checkBalance();
                System.out.println("Your account balance is: " + balance);
            } else if (choice.equals("4")) {
                System.out.println("Thank you for using the ATM");
                break;
            } else {
                System.out.println("Invalid choice. Please select a valid option (1/2/3/4).");
            }
        }
        scanner.close();
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        String accountHolder = "John Doe";
        double initialBalance = 10000;
        BankAccount userAccount = new BankAccount(accountHolder, initialBalance);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}