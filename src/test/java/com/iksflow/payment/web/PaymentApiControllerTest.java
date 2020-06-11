package com.iksflow.payment.web;

import com.iksflow.payment.domain.payment.Payment;
import com.iksflow.payment.domain.payment.PaymentRepository;
import com.iksflow.payment.web.dto.PaymentSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PaymentRepository paymentRepository;

    @After
    public void tearDown() {
        paymentRepository.deleteAll();
    }

    @Test
    public void insertPaymentData() throws Exception {
        // given
        String cardNumber = "1234567890123456";
        String expiryMonthYear = "0520";
        String cvcNumber = "123";
        String installMonth = "00";
        BigDecimal totalAmount = BigDecimal.valueOf(100000);
        BigDecimal vatAmount = BigDecimal.ZERO;

        PaymentSaveRequestDto requestDto = PaymentSaveRequestDto.builder()
                .cardNumber(cardNumber)
                .expiryMonthYear(expiryMonthYear)
                .cvcNumber(cvcNumber)
                .installMonth(installMonth)
                .totalAmount(totalAmount)
                .vatAmount(vatAmount)
                .build();

        String url = "http://localhost:" + port + "/api/v1/payment";

        //when
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestDto, String.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);

//        List<Payment> all = paymentRepository.findAll();
//        Payment payment = all.get(0);
//        assertThat(payment.getTid())

    }

    @Test
    public void updatePaymentData() {
//        //given
//        Payment savedPayment = paymentRepository.save(com.iksflow.payment.domain.payments.Payment.builder()
//                .cardNo("1111222233334444")
//                .validYm("0520")
//                .cvcNo(123L)
//                .istmtAmt(0L)
//                .payAmt(BigDecimal.valueOf(10000))
//                .build());
//
//        Long updateId = savedPayment.getPayNo();
//        String expectedCardNo = "9999888877776666";
//        String expectedValidYm = "0521";
//        BigDecimal expectedPayAmt = BigDecimal.valueOf(5000);
//
//        PaymentUpdateRequestDto requestDto = PaymentUpdateRequestDto.builder()
//                .payAmt(BigDecimal.valueOf(5000))
//                .build();
//
//        String url = "http://localhost:" + port + "/api/v1/payments/" + updateId;
//
//        HttpEntity<PaymentUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//        // when
//        ResponseEntity<Long> responseEntity = restTemplate
//                .exchange(url, HttpMethod.PUT, requestEntity, Long.class);
//
//        // then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Payment> all = paymentRepository.findAll();
////        assertThat(all.get(0).getCardNo()).isEqualTo(expectedCardNo);
////        assertThat(all.get(0).getValidYm()).isEqualTo(expectedValidYm);
////        assertThat(all.get(0).getPayAmt()).isEqualTo(expectedPayAmt);

    }

}
