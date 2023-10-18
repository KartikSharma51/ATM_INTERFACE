import java.util.Scanner;

public class ATM {
    private double balance;
    private String accountNumber;
    private String pin;

    public ATM(String accountNumber, String pin) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = 1000.00; // Initial balance, you can modify this as needed.
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

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
                    System.out.println("Thank you for using this ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    public void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to deposit: $");
        double amount = scanner.nextDouble();
        balance += amount;
        System.out.println("Deposited $" + amount + " successfully.");
    }

    public void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount to withdraw: $");
        double amount = scanner.nextDouble();

        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " successfully.");
        }
    }

    public static void main(String[] args) {
        ATM atm = new ATM("123456789", "1234"); // Replace with your account number and PIN
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your account number: ");
        String inputAccountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String inputPin = scanner.nextLine();

        if (inputAccountNumber.equals(atm.accountNumber) && inputPin.equals(atm.pin)) {
            System.out.println("Login successful.");
            atm.displayMenu();
        } else {
            System.out.println("Invalid account number or PIN. Exiting.");
        }
    }
}
