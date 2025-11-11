package com.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter account holder name: ");
        String name = sc.nextLine();
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        System.out.print("Set user ID: ");
        String userId = sc.nextLine();
        System.out.print("Set password: ");
        String password = sc.nextLine();
        System.out.print("Enter account type (Savings/Current): ");
        String accType = sc.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        Bankaccount account = new Bankaccount(name, accNum, userId, password,accType, balance);
        Bankaccountservice service = new Bankaccountservice();


        System.out.print("\nLogin - Enter User ID: ");
        String loginId = sc.nextLine();
        System.out.print("Enter Password: ");
        String loginPass = sc.nextLine();

        if (service.login(account, loginId, loginPass)) {
            System.out.println("Login successful!");

            boolean exit = false;
            while (!exit) {
                System.out.println("\n1. Deposit\n2. Withdraw\n3. Display Account\n4. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double dep = sc.nextDouble();
                        service.deposit(account, dep);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double wd = sc.nextDouble();
                        service.withdraw(account, wd);
                        break;
                    case 3:
                        service.displayAccount(account);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                }
            }
        }
        else {
            System.out.println("Login failed! Invalid credentials.");
        }

        sc.close();
    }
}