package com.example.user_service.service;


import com.example.user_service.model.Account;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {
    private final Map<Integer, Account> accounts = new HashMap<>();
    private int accountIdCounter = 1;

    public Account createAccount(double balance, String name) {
        Account account = new Account(accountIdCounter++, balance, name);
        accounts.put(account.getId(), account);
        return account;
    }

    public Account deposit(int id, double amount) {
        Account account = accounts.get(id);
        if (account != null) account.deposit(amount);
        return account;
    }

    public Account withdraw(int id, double amount) {
        Account account = accounts.get(id);
        if (account != null) account.withdraw(amount);
        return account;
    }

    public Account block(int id) {
        Account account = accounts.get(id);
        if (account != null) account.block();
        return account;
    }

    public Account unblock(int id) {
        Account account = accounts.get(id);
        if (account != null) account.unblock();
        return account;
    }

    public Map<Integer, Account> getAccounts() {
        return accounts;
    }

    public Account getAccount(int accountId) { return accounts.get(accountId); }
}