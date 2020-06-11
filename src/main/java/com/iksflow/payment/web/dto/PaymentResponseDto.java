package com.iksflow.payment.web.dto;

import com.iksflow.payment.domain.payment.Payment;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentResponseDto {

    private Long payNo;
    private String cardNo;
    private String validYm;
    private Long cvcNo;
    private Long istmtAmt;
    private BigDecimal payAmt;

    public PaymentResponseDto(Payment entity) {
    }
}
