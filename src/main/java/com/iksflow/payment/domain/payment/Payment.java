package com.iksflow.payment.domain.payment;

import com.iksflow.payment.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private String tid;

    @Column(nullable = false)
    private String state;

    @OneToMany(mappedBy = "payment")
    private List<PaymentDetail> paymentDetails = new ArrayList<>();

    @Builder
    public Payment(String tid, String state, List<PaymentDetail> paymentDetails) {
        this.tid = tid;
        this.state = state;
        this.paymentDetails = paymentDetails;
    }

    public void update(String state) {
        this.state = state;
    }

    private String paymentStringData() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%4s", 446))
                .append(String.format("%-10s", "PAYMENT"))
                .append(String.format("%20s", 1));
        return sb.toString().replace(" ", "_");
    }
}
