package com.example.user_service.controller;


import com.example.user_service.model.Payment;
import com.example.user_service.service.AccountService;
import com.example.user_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    private final AccountService accountService;

    public PaymentController(PaymentService paymentService, AccountService accountService) {
        this.paymentService = paymentService;
        this.accountService = accountService;
    }

    @PostMapping
    public Payment createPayment(@RequestBody Map<String, Object> request) {
        double amount = (Double) request.get("amount");
        int accountId = (Integer) request.get("accountId");
        int creditCardId = (Integer) request.get("creditCardId");
        return paymentService.createPayment(amount, accountId, creditCardId);
    }

    @GetMapping("/account/{accountId}")
    public Collection<Payment> getPaymentsByAccountId(@PathVariable int accountId) {
        return paymentService.getPayments().stream()
                .filter(payment -> payment.getAccountId() == accountId)
                .collect(Collectors.toList());
    }

    @GetMapping("/credit-card/{creditCardId}")
    public Collection<Payment> getPaymentsByCreditCardId(@PathVariable int creditCardId) {
        return paymentService.getPayments().stream()
                .filter(payment -> payment.getCreditCardId() == creditCardId)
                .collect(Collectors.toList());
    }
}
