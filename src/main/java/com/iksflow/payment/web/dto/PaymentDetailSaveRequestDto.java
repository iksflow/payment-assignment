package com.iksflow.payment.web.dto;


import com.iksflow.payment.domain.payment.Payment;
import com.iksflow.payment.domain.payment.PaymentDetail;
import com.iksflow.payment.utils.PaymentUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class PaymentDetailSaveRequestDto {
    @Autowired
    PaymentUtil pu;

    private String cardNumber;
    private String expiryMonthYear;
    private String cvcNumber;
    private String installMonth;
    private BigDecimal totalAmount;
    private BigDecimal vatAmount;

    @Builder
    public PaymentDetailSaveRequestDto(String cardNumber, String expiryMonthYear, String cvcNumber,
                                       String installMonth, BigDecimal totalAmount, BigDecimal vatAmount) {
        this.cardNumber = cardNumber;
        this.expiryMonthYear = expiryMonthYear;
        this.cvcNumber = cvcNumber;
        this.installMonth = installMonth;
        this.totalAmount = totalAmount;
        this.vatAmount = vatAmount;
    }


    public PaymentDetail toEntity() {
        return PaymentDetail.builder()
                .aid(pu.createUniqueId())
                .paymentInfo(pu.encrypt(cardNumber))
                .build();
    }
}
