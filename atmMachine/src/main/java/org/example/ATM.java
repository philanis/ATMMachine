package org.example;

import java.util.Scanner;

public class ATM {
    private float balance;
    private int pin = 1234;
    private Scanner scanner = new Scanner(System.in);
    private double interestRate = 0.0185;
    private int deposits = 0;
    private int withdrawals = 0;
    private int opt = 0;

    public void checkPin() {
        int attempts = 0;
        while( attempts < 3){
            System.out.println("Enter your pin: ");
            int yourPin = scanner.nextInt();
            if (yourPin == pin) {
                menu();
                if(opt == 5) break;
            } else {
                System.out.println("Enter a valid pin");
                attempts++;
            }
        }
        if(attempts >= 3) System.out.println("Your account has been locked due to multiple failed attempts. Please contact customer support.");
    }

    public void menu() {
        //int opt = 0;
        while (opt != 5) {
            System.out.println("Which of the following services do you need?");
            System.out.println();
            System.out.println("1. Check Account Balance");
            System.out.println("2. Withdraw money");
            System.out.println("3. Deposit money");
            System.out.println("4. Calculate interest");
            System.out.println("5. EXIT");


            System.out.println("Enter an option: ");
            if(scanner.hasNextInt()){
                opt = scanner.nextInt();
            }else{
                System.out.println("Enter a valid option");
                scanner.next();
                continue;
            }

            if (opt == 1) {
                checkBalance();
                break;
            } else if (opt == 2) {
                withdrawMoney();
                break;
            } else if (opt == 3) {
                depositMoney();
                break;
            } else if (opt == 4) {
                calculateInterest();
                break;
            } else if (opt == 5) {
                System.out.println("Thank you for banking with us!");
                break;
            } else {
                System.out.println("Enter a valid option");
            }
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
        System.out.println();
        menu();
    }

    public void withdrawMoney() {
        System.out.println("Enter amount to withdraw: ");
        float amount = scanner.nextFloat();
        if (amount > balance) {
            System.out.println("Insufficient balance");
        } else {
            balance -= amount;
            withdrawals++;
            System.out.println(amount + " withdrawal successful");
            System.out.println();
        }
        menu();
    }

    public void depositMoney() {
        System.out.println("Enter the amount: ");
        float amount = scanner.nextFloat();
        balance = balance + amount;
        deposits++;
        System.out.println(amount + " deposited successfully");
        System.out.println();
        menu();
    }
    public void calculateInterest(){
        System.out.println("Enter years of accrued interest");
        Scanner s = new Scanner(System.in);
        int years = s.nextInt();
        //double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, your balance will be: " + newBalance);
        System.out.println();
        menu();
    }
}
