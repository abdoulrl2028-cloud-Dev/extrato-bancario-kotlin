package com.extrato.server.controller;

import com.extrato.server.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TransactionController {

    @GetMapping("/transactions")
    public List<Transaction> list() {
        return Arrays.asList(
                new Transaction("2025-12-01T10:00:00Z", "Pagamento - Loja A", -120.50, 987.50),
                new Transaction("2025-11-30T08:30:00Z", "Depósito", 500.00, 1108.00),
                new Transaction("2025-11-28T12:15:00Z", "Transferência recebida", 250.00, 608.00)
        );
    }
}
