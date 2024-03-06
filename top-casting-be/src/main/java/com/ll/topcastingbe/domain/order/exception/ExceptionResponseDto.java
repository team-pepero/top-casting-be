package com.ll.topcastingbe.domain.order.exception;

import lombok.Builder;

@Builder
public record ExceptionResponseDto(String message) {

    public static ExceptionResponseDto of(final String message) {
        final ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .message(message)
                .build();

        return exceptionResponseDto;
    }
}