package com.payment;

import com.payment.model.PaymentRequest;
import com.payment.model.PaymentResponse;
import com.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void testProcessPayment_ValidCard() {
        PaymentRequest request = new PaymentRequest();
        request.setCardNumber("1234567812345670");
        request.setExpiryDate("12/25");
        request.setCvv("123");
        request.setAmount(100.00);
        request.setCurrency("USD");
        request.setMerchantId("M123");

        PaymentResponse response = paymentService.processPayment(request);
        assertEquals("Transaction Approved", response.getMessage());
        assertEquals("Approved", response.getStatus());
    }

    @Test
    public void testProcessPayment_InvalidCard() {
        PaymentRequest request = new PaymentRequest();
        request.setCardNumber("1234567812345671");
        request.setExpiryDate("12/25");
        request.setCvv("123");
        request.setAmount(100.00);
        request.setCurrency("USD");
        request.setMerchantId("M123");

        PaymentResponse response = paymentService.processPayment(request);
        assertEquals("Invalid card number", response.getMessage());
        assertEquals("Denied", response.getStatus());
    }
}
