package com.iksflow.payment.domain.payment;

import com.iksflow.payment.config.JasyptConfig;
import org.jasypt.encryption.StringEncryptor;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    StringEncryptor encryptor;

    @After
    public void cleanup() {
        paymentRepository.deleteAll();
    }

    @Test
    public void saveAndLoadPaymentData() {
//        // given
//        String cardNo = "1122334455667788";
//
//        paymentRepository.save(com.iksflow.payment.domain.payments.Payment.builder().cardNo(cardNo).build());
//
//        // when
//        List<Payment> paymentList = paymentRepository.findAll();
//
//        // then
//        Payment payment = paymentList.get(0);
//        assertThat(payment.getCardNo()).isEqualTo(cardNo);
    }

    @Test
    public void baseTimeEntity() {
//        // given
//        LocalDateTime now = LocalDateTime.of(2020, 6, 8, 0, 0, 0);
//        paymentRepository.save(com.iksflow.payment.domain.payments.Payment.builder()
//                .cardNo("1234")
//                .validYm("0520")
//                .cvcNo(123L)
//                .istmtAmt(24L)
//                .payAmt(BigDecimal.valueOf(100))
//                .build());
//
//        // when
//        List<Payment> paymentList = paymentRepository.findAll();
//
//        // then
//        Payment payment = paymentList.get(0);
//
//        System.out.println(">>>>>>>> createDate = " + payment.getCreatedDate() + ", modifiedDate = " + payment.getModifiedDate());
//
//        assertThat(payment.getCreatedDate()).isAfter(now);
//        assertThat(payment.getModifiedDate()).isAfter(now);

    }
}
