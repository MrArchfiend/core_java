package com.bank;

public class Bankaccount {
    private String accountHolder;
    private String accountNumber;
    private String userId;
    private String accountType;
    private String password;
    private double balance;

    public Bankaccount(String accountHolder, String accountNumber, String userId, String password,String accountType, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
        this.password = password;
        this.balance = balance;
    }


    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}