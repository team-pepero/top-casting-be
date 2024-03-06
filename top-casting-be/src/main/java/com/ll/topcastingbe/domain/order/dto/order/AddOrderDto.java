package com.ll.topcastingbe.domain.order.dto.order;

import com.ll.topcastingbe.domain.order.dto.order.request.AddOrderRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddOrderDto(@NotBlank(message = "주문자 이름은 반드시 입력해야합니다.") String customerName,
                          @NotBlank(message = "주문자 주소는 반드시 입력해야합니다.") String customerAddress,
                          @NotBlank(message = "주문자 전화번호는 반드시 입력해야합니다.") String customerPhoneNumber,
                          @NotNull(message = "아이템갯수는 반드시 입력해야합니다.") Long totalItemQuantity,
                          @NotNull(message = "가격은 반드시 입력해야합니다.") Long totalItemPrice) {

    public AddOrderRequest toAddOrderRequest() {
        AddOrderRequest addOrderRequest = AddOrderRequest.builder()
                .customerName(customerName)
                .customerAddress(customerAddress)
                .customerPhoneNumber(customerPhoneNumber)
                .totalItemQuantity(totalItemQuantity)
                .totalItemPrice(totalItemPrice)
                .build();

        return addOrderRequest;
    }
}