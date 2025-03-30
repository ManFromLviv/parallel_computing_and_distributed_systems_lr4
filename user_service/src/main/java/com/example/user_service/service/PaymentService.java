package com.example.user_service.service;

import com.example.user_service.model.Account;
import com.example.user_service.model.CreditCard;
import com.example.user_service.model.Payment;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PaymentService {
    private final Map<Integer, Payment> payments = new HashMap<>();
    private final CreditCardService creditCardService;
    private final AccountService accountService;

    private int paymentIdCounter = 1;

    public PaymentService(CreditCardService creditCardService, AccountService accountService) {
        this.accountService = accountService;
        this.creditCardService = creditCardService;

    }

    public Payment createPayment(double amount, int accountId, int creditCardId) {
        CreditCard creditCard = creditCardService.getCreditCard(creditCardId);
        Account account = creditCard != null ? creditCard.getAccount() : null;
        Account accountInData = accountService.getAccount(accountId);
        Payment payment = null;
        if (accountInData != null && account != null && creditCard != null && account.getId() == accountInData.getId()) {
            double balanceBefore = account.getBalance();
            if (amount > 0) {
                account.deposit(amount);
            } else if (amount < 0) {
                account.withdraw(-amount);
            }
            double balanceAfter = account.getBalance();
            if (balanceAfter != balanceBefore) {
                payment = new Payment(paymentIdCounter++, amount, accountId, creditCardId, false);
                payments.put(payment.getId(), payment);
                payment.setStatus(true);
            }
        }
        return payment;
    }

    public Collection<Payment> getPayments() {
        return payments.values();
    }
}
