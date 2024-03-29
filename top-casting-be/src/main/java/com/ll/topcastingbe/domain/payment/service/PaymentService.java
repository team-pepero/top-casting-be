package com.ll.topcastingbe.domain.payment.service;

import com.ll.topcastingbe.domain.order.entity.Orders;
import com.ll.topcastingbe.domain.payment.dto.response.AddTossPaymentResponse;
import com.ll.topcastingbe.domain.payment.entity.Payment;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;


public interface PaymentService {

    CompletableFuture<AddTossPaymentResponse> addPayment(final UUID orderId, final String paymentKey, final Long price);

    Payment createPayment(final Orders order, final Long price, final String paymentKey);

}
