package BankingSystem;
import java.util.Scanner;
public class Account {
    String CustomerName;
    String CustomerID;
    int balance = 0;
    int PreviousTransaction;

    public Account(String Name, String ID) {
        CustomerName = Name;
        CustomerID = ID;

    }

    public void deposit(int amount) {
        balance += amount;
        PreviousTransaction = amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
        PreviousTransaction = -amount;
    }

     void ViewPreviousTransaction()
    {
        if (PreviousTransaction > 0) {
            System.out.println("Amount deposited: " + PreviousTransaction);
        } else if (PreviousTransaction < 0) System.out.println("Amount withdrawn: " + Math.abs(PreviousTransaction));
        else {
            System.out.println("No transaction occurred!");
        }


    }

    public void CalculateInterest(int time) {
        balance = balance * 100 * time;
        System.out.println("The amount after interest will be" + balance);
    }

    void showMenu() {
        char option = '\0';
                Scanner scanner = new Scanner(System.in);
                System.out.println("Welcome, " + CustomerName + "!");
                System.out.println("Your ID is: " + CustomerID);
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println();
                System.out.println("A. Check your balance");
                System.out.println("B. Make a deposit");
                System.out.println("C. Make a withdrawal");
                System.out.println("D. View previous transaction");
                System.out.println("E. Calculate interest");
                System.out.println("F. Exit");

                do {
                    System.out.println();
                    System.out.println("Enter an option: ");
                    char option1 = scanner.next().charAt(0);
                    option = Character.toUpperCase(option1);
                    System.out.println();


            switch(option) {
                //Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("====================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //Case 'B' allows the user to deposit money into their account using the 'deposit' function
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
                case 'D':
                    System.out.println("====================================");
                    ViewPreviousTransaction();
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    CalculateInterest(years);
                    break;
                //Case 'F' exits the user from their account
                case 'F':
                    System.out.println("====================================");
                    break;
                //The default case let's the user know that they entered an invalid character and how to enter a valid one
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
                    break;
            }
        } while(option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}

