package com.example.user_service.model;

public class Account {
    private int id;
    private double balance;
    private boolean isBlocked;
    private String name;

    public Account(int id, double balance, String name) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.isBlocked = false;
    }

    public int getId() { return id; }
    public double getBalance() { return balance; }
    public boolean isBlocked() { return isBlocked; }
    public void deposit(double amount) { if (!isBlocked) this.balance += amount; }
    public void withdraw(double amount) { if (!isBlocked && balance >= amount) this.balance -= amount; }
    public void block() { this.isBlocked = true; }
    public void unblock() { this.isBlocked = false; }
    public String getName() { return name; }
}
