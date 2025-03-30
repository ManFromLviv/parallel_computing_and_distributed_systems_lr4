package com.example.user_service.model;

import java.util.Date;

public class Payment {
    private int id;
    private double amount;
    private String timestamp;
    private int accountId;
    private int creditCardId;
    private boolean status;

    public Payment(int id, double amount, int accountId, int creditCardId, boolean status) {
        this.id = id;
        this.amount = amount;
        this.timestamp = new Date().toString();
        this.accountId = accountId;
        this.creditCardId = creditCardId;
        this.status = status;
    }

    public int getId() { return id; }

    public void setStatus(boolean status) { this.status = status; }
    public boolean getStatus() { return status; }
    public double getAmount() { return amount; }
    public String getTimestamp() { return timestamp; }
    public int getAccountId() { return accountId; }
    public int getCreditCardId() { return creditCardId; }
}

