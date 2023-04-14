package com.ahmedzahran.PaymentServiceTwo.service;

import com.ahmedzahran.PaymentServiceTwo.entity.TransactionDetails;
import com.ahmedzahran.PaymentServiceTwo.model.PaymentMode;
import com.ahmedzahran.PaymentServiceTwo.model.PaymentRequest;
import com.ahmedzahran.PaymentServiceTwo.model.PaymentResponse;
import com.ahmedzahran.PaymentServiceTwo.repository.TransactionDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("Recording payment details : {}", paymentRequest);

        TransactionDetails transactionDetails = TransactionDetails.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();

        transactionDetailsRepository.save(transactionDetails);
        log.info("Transaction details with ID: {}, saved Successfully",transactionDetails.getId());

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetails(long orderId) {
        log.info("Getting payment details for order Id: {}", orderId);

        TransactionDetails transactionDetails = transactionDetailsRepository.findByOrderId(orderId);

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .paymentId(transactionDetails.getId())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .paymentDate(transactionDetails.getPaymentDate())
                .orderId(transactionDetails.getId())
                .status(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();
        return paymentResponse;
    }
}
