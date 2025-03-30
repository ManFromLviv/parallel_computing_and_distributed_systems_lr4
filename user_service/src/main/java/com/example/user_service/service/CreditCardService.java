package com.example.user_service.service;


import com.example.user_service.model.Account;
import com.example.user_service.model.CreditCard;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CreditCardService {
    private final Map<Integer, CreditCard> creditCards = new HashMap<>();
    private final AccountService accountService;
    private int creditCardIdCounter = 1;

    public CreditCardService(AccountService accountService) {
        this.accountService = accountService;
    }

    public CreditCard createCreditCard(String cardNumber, int accountId) {
        Account account = accountService.getAccount(accountId);
        if (account != null && !account.isBlocked()) {
            CreditCard creditCard = new CreditCard(creditCardIdCounter++, cardNumber, account);
            creditCards.put(creditCard.getId(), creditCard);
            return creditCard;
        }
        return null;
    }

    public Collection<CreditCard> getCreditCards() {
        return creditCards.values();
    }

    public CreditCard getCreditCard(int creditCardId) { return creditCards.get(creditCardId); }
}