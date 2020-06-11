package com.iksflow.payment.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class PaymentUpdateRequestDto {
    private BigDecimal payAmt;

    @Builder
    public PaymentUpdateRequestDto(BigDecimal payAmt) {
        this.payAmt = payAmt;
    }
}
