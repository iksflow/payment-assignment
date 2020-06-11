package com.iksflow.payment.web.dto;

import com.iksflow.payment.domain.payment.Payment;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentListResponseDto {
    private Long payNo;
    private String cardNo;
    private BigDecimal payAmt;
    private BigDecimal vatAmt;


    public PaymentListResponseDto(Payment entity) {
//        this.payNo = entity.getPayNo();
//        this.cardNo = entity.getCardNo();
//        this.payAmt = entity.getPayAmt();
//        this.vatAmt = entity.getVatAmt();
    }
}
