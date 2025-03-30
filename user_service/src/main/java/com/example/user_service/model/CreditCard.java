package com.example.user_service.model;

public class CreditCard {
    private int id;
    private String cardNumber;
    private Account account;

    public CreditCard(int id, String cardNumber, Account account) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public int getId() { return id; }
    public String getCardNumber() { return cardNumber; }
    public Account getAccount() { return account; }
}