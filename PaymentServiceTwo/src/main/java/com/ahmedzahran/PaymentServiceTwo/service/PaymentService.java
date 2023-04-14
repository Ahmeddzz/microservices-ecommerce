package com.ahmedzahran.PaymentServiceTwo.service;

import com.ahmedzahran.PaymentServiceTwo.model.PaymentRequest;
import com.ahmedzahran.PaymentServiceTwo.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetails(long orderId);
}
