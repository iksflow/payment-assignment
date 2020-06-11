package com.iksflow.payment.domain.payment;

import com.iksflow.payment.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "payment_detail")
public class PaymentDetail extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, unique = true)
    private String aid;

    @Column(length = 450, nullable = false)
    private String paymentInfo;

    @ManyToOne
    @JoinColumn(name = "payment_tid")
    private Payment payment;

    @Builder
    public PaymentDetail(Long id, String aid, String paymentInfo, Payment payment) {
        this.id = id;
        this.aid = aid;
        this.paymentInfo = paymentInfo;
        this.payment = payment;
    }
}
