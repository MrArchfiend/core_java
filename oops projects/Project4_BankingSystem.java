/*
 Banking System
 - Abstract BankAccount with concrete deposit/withdraw and abstract calculateInterest
 - Subclasses SavingsAccount and CurrentAccount
 - Interface Loanable
*/
import java.util.*;

public class Project4_BankingSystem {
    public static abstract class BankAccount {
        private String accountNumber;
        private String holderName;
        private double balance;

        public BankAccount(String accountNumber, String holderName, double balance) {
            this.accountNumber = accountNumber;
            this.holderName = holderName;
            this.balance = balance;
        }

        public String getAccountNumber() { return accountNumber; }
        public String getHolderName() { return holderName; }
        public double getBalance() { return balance; }

        public void deposit(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Deposit must be positive");
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount <= 0) throw new IllegalArgumentException("Withdraw must be positive");
            if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
            balance -= amount;
        }

        public abstract double calculateInterest();
    }

    public interface Loanable {
        boolean applyForLoan(double amount);
        String calculateLoanEligibility();
    }

    public static class SavingsAccount extends BankAccount implements Loanable {
        private double interestRate; // annual

        public SavingsAccount(String acc, String holder, double balance, double interestRate) {
            super(acc, holder, balance);
            this.interestRate = interestRate;
        }

        @Override
        public double calculateInterest() {
            return getBalance() * (interestRate/100.0);
        }

        @Override
        public boolean applyForLoan(double amount) {
            // simple rule: eligible if balance > 10000
            return getBalance() > 10000 && amount < getBalance() * 5;
        }

        @Override
        public String calculateLoanEligibility() {
            return applyForLoan(0) ? "Eligible for loan" : "Not eligible for loan";
        }
    }

    public static class CurrentAccount extends BankAccount {
        public CurrentAccount(String acc, String holder, double balance) {
            super(acc, holder, balance);
        }

        @Override
        public double calculateInterest() {
            return 0.0; // typically no interest
        }
    }

    public static void main(String[] args) {
        List<BankAccount> accounts = Arrays.asList(
            new SavingsAccount("S1001","Meena",20000,4.0),
            new CurrentAccount("C2001","Rohan",5000)
        );

        // Process accounts polymorphically
        for (BankAccount a : accounts) {
            System.out.println("Account: " + a.getAccountNumber() + " Holder: " + a.getHolderName() + " Balance: " + a.getBalance() + " Interest: " + a.calculateInterest());
            if (a instanceof Loanable) {
                System.out.println(((Loanable)a).calculateLoanEligibility());
            }
        }
    }
}
