package com.iksflow.payment.web.dto;

import com.iksflow.payment.domain.payment.Payment;
import com.iksflow.payment.utils.PaymentUtil;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class PaymentSaveRequestDto {

    private String cardNumber;
    private String expiryMonthYear;
    private String cvcNumber;
    private String installMonth;
    private BigDecimal totalAmount;
    private BigDecimal vatAmount;

    @Builder
    public PaymentSaveRequestDto(String cardNumber, String expiryMonthYear, String cvcNumber,
                                 String installMonth, BigDecimal totalAmount, BigDecimal vatAmount) {
        this.cardNumber = cardNumber;
        this.expiryMonthYear = expiryMonthYear;
        this.cvcNumber = cvcNumber;
        this.installMonth = installMonth;
        this.totalAmount = totalAmount;
        this.vatAmount = vatAmount;
    }

    public Payment toEntity(String uniqueId) {
        return Payment.builder()
                .tid(uniqueId)
                .state("PAYMENT")
                .paymentDetails(null)
                .build();
    }
}
