package com.iksflow.payment.domain.payment;

import com.iksflow.payment.utils.PaymentUtil;
import org.jasypt.encryption.StringEncryptor;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentDetailRepositoryTest {

    @Autowired
    PaymentUtil pu;
    @Autowired
    PaymentDetailRepository paymentDetailRepository;

    @Autowired
    StringEncryptor encryptor;

    @After
    public void cleanup() {
        paymentDetailRepository.deleteAll();
    }

    @Test
    public void insertAndSelectPaymentData() {
        // given
        String tid = "12345678901234567890";
        String aid = "10002000300040005000";
        String paymentInfo = "abc";

        paymentDetailRepository.save(PaymentDetail.builder()
                .aid(aid)
                .paymentInfo(paymentInfo)
                .build());
        // when
        List<PaymentDetail> paymentDetailList = paymentDetailRepository.findAll();

        // then
        PaymentDetail paymentDetail = paymentDetailList.get(0);
        assertThat(paymentDetail.getAid()).isEqualTo(aid);
        assertThat(paymentDetail.getPaymentInfo()).isEqualTo(paymentInfo);

    }

    @Test
    public void encryptTest() {
        System.out.println(encryptor.encrypt("hello"));
    }

    @Test
    public void createUidTest() {
        String uuid = pu.createUniqueId();
        assertThat(uuid.length()).isEqualTo(20);
    }
}
