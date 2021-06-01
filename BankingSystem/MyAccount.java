package BankingSystem;
import java.util.Scanner;

public class MyAccount {
    int balance;
    int PreviousTransaction;
    String Name;
    String UID;

    public MyAccount(String name, String uid) {
        Name = name;
        UID = uid;
        ShowMenu();
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance += amount;
            PreviousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance -= amount;
            PreviousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (PreviousTransaction > 0) {
            System.out.println("Deposited: " + PreviousTransaction);
        } else if (PreviousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(PreviousTransaction));
        } else {
            System.out.println("No transaction occurred!");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }

    void ShowMenu() {
        char option = '\0';
        System.out.println("Welcome, " + Name + "!");
        System.out.println("Your ID is: " + UID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        Scanner obj = new Scanner(System.in);

        do {
            System.out.println("Enter your choice: ");
            char option1 = obj.next().charAt(0);
            option = Character.toUpperCase(option1);

            switch (option) {
                case 'A':
                    System.out.println("Your current balance is: " + balance + "Rs.");
                    break;

                case 'B':
                    System.out.println("Enter an amount to be deposited: ");
                    int amount = obj.nextInt();
                    deposit(amount);
                    System.out.println("Amount deposited successfully!");
                    break;

                case 'C':
                    System.out.println("Enter an amount to be withdrawn: ");
                    int amount2 = obj.nextInt();
                    deposit(amount2);
                    System.out.println("Amount withdrawn successfully!");
                    break;

                case 'D':
                    getPreviousTransaction();
                    break;

                case 'E':
                    int years = obj.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println("Sorry the option you chose is incorrect!");


            }

        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}




