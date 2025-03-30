package com.example.user_service.controller;

import com.example.user_service.model.Account;
import com.example.user_service.service.AccountService;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/accounts")
class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account createAccount(@RequestBody Map<String, Object> request) {
        double balance = (Double) request.get("balance");
        String name = (String) request.get("name");
        return accountService.createAccount(balance, name);
    }


    @PostMapping("/block/{id}")
    public String blockAccount(@PathVariable int id) {
        try {
            Account account = accountService.getAccount(id);
            if (account != null) {
                accountService.block(id);
                return "Account id " + id + " blocked.";
            }
            return "Account with id " + id + " not found and not blocked";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/unblock/{id}")
    public String unblockAccount(@PathVariable int id) {
        try {
            Account account = accountService.getAccount(id);
            if (account != null) {
                accountService.unblock(id);
                return "Account id " + id + " unblocked.";
            }
            return "Account with id " + id + " not found and not unblocked";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}