package com.example.user_service.controller;


import com.example.user_service.model.CreditCard;
import com.example.user_service.service.AccountService;
import com.example.user_service.service.CreditCardService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/credit-cards")
class CreditCardController {
    private final CreditCardService creditCardService;
    private final AccountService accountService;

    public CreditCardController(CreditCardService creditCardService, AccountService accountService) {
        this.creditCardService = creditCardService;
        this.accountService = accountService;
    }

    @PostMapping
    public CreditCard createCreditCard(@RequestBody Map<String, Object> request) {
        String cardNumber = (String) request.get("cardNumber");
        int accountId = (Integer) request.get("accountId");
        return creditCardService.createCreditCard(cardNumber, accountId);
    }

    @GetMapping("/account/{accountId}")
    public Collection<CreditCard> getCreditCardsByAccountId(@PathVariable int accountId) {
        return creditCardService.getCreditCards().stream()
                .filter(creditCard -> creditCard.getAccount().getId() == accountId)
                .collect(Collectors.toList());
    }
}