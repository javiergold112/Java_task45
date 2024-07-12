package com.payment.repository;

import com.payment.model.PaymentRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class TransactionRepository {

    private Map<String, PaymentRequest> transactionStore = new HashMap<>();

    public void saveTransaction(PaymentRequest paymentRequest, String status) {
        // Save transaction to in-memory store with a unique ID (simplified)
        transactionStore.put(generateTransactionId(), paymentRequest);
    }

    private String generateTransactionId() {
        return "TXN" + (transactionStore.size() + 1);
    }
}
