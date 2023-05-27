package Controller;

import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    public void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("$" + amount + " deposited successfully.");
        checkBalance();
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("$" + amount + " withdrawn successfully.");
            checkBalance();
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0, 1234); // Initialize ATM with initial balance and PIN

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM!");

        int attempts = 3;
        while (attempts > 0) {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (atm.validatePin(enteredPin)) {
                System.out.println("PIN accepted. What would you like to do?");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        atm.withdraw(withdrawalAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } else {
                attempts--;
                System.out.println("Invalid PIN. " + attempts + " attempt(s) remaining.");
                if (attempts == 0) {
                    System.out.println("Exceeded maximum attempts. Exiting...");
                    System.exit(0);
                }
            }
        }
    }
}
