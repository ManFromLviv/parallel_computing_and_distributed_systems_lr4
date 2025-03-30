package com.example.admin_service.model;

import com.example.user_service.model.Account;

public class Administrator {
    private int id;
    private String name;

    public Administrator(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public void unblockAccount(Account account) { account.unblock(); }
}