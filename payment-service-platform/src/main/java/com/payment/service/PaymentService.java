package com.payment.service;

import com.payment.model.PaymentRequest;
import com.payment.model.PaymentResponse;
import com.payment.repository.TransactionRepository;
import com.payment.util.LuhnAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private TransactionRepository transactionRepository;

    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
        // Validate card using Luhn's algorithm
        if (!LuhnAlgorithm.validate(paymentRequest.getCardNumber())) {
            return new PaymentResponse("Invalid card number", "Denied");
        }

        // Implement BIN routing logic
        String bin = paymentRequest.getCardNumber().substring(0, 6);
        int sum = bin.chars().map(Character::getNumericValue).sum();
        boolean isEven = (sum % 2 == 0);

        // Mock acquirer decision
        boolean approved = (isEven ?
                Character.getNumericValue(paymentRequest.getCardNumber().charAt(paymentRequest.getCardNumber().length() - 1)) % 2 == 0 :
                Character.getNumericValue(paymentRequest.getCardNumber().charAt(paymentRequest.getCardNumber().length() - 1)) % 2 == 0);

        String status = approved ? "Approved" : "Denied";
        transactionRepository.saveTransaction(paymentRequest, status);

        return new PaymentResponse("Transaction " + status, status);
    }
}
