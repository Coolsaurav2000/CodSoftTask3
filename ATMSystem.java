import java.util.Scanner;

public class ATMSystem {

    // BankAccount class
    public static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public boolean withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
                return false;
            } else if (amount > balance) {
                System.out.println("Insufficient balance.");
                return false;
            } else {
                balance -= amount;
                return true;
            }
        }

        public void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid amount. Please enter a positive value.");
            } else {
                balance += amount;
            }
        }
    }

    // ATM class
    public static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void displayMenu() {
            while (true) {
                System.out.println("\nATM Menu:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private void checkBalance() {
            System.out.println("Your current balance is: $" + account.getBalance());
        }

        private void deposit() {
            System.out.print("Enter amount to deposit: $");
            double amount = scanner.nextDouble();
            account.deposit(amount);
            System.out.println("Deposited: $" + amount);
            checkBalance();
        }

        private void withdraw() {
            System.out.print("Enter amount to withdraw: $");
            double amount = scanner.nextDouble();
            if (account.withdraw(amount)) {
                System.out.println("Withdrawn: $" + amount);
            }
            checkBalance();
        }
    }

    // Main method to run the ATM system
    public static void main(String[] args) {
        // Initialize the bank account with an initial balance
        BankAccount account = new BankAccount(1000.00);

        // Initialize the ATM with the bank account
        ATM atm = new ATM(account);

        // Display the ATM menu
        atm.displayMenu();
    }
}
