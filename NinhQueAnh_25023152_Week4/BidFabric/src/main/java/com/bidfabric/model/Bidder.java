package com.bidfabric.model;

public class Bidder extends User{

    private double balance;
    public Bidder(String username, String password, String fullName, double balance) {
        super(username, password, fullName);
        this.balance = balance;

    }
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getRole() {
        return "BIDDER";
    }
}
