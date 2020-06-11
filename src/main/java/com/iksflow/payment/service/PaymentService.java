package com.iksflow.payment.service;

import com.iksflow.payment.domain.payment.Payment;
import com.iksflow.payment.domain.payment.PaymentDetailRepository;
import com.iksflow.payment.domain.payment.PaymentRepository;
import com.iksflow.payment.utils.PaymentUtil;
import com.iksflow.payment.web.dto.PaymentResponseDto;
import com.iksflow.payment.web.dto.PaymentSaveRequestDto;
import com.iksflow.payment.web.dto.PaymentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PaymentService {
    @Autowired
    PaymentUtil pu;

    private final PaymentRepository paymentRepository;
    private final PaymentDetailRepository paymentDetailRepository;

    @Transactional
    public String save(PaymentSaveRequestDto requestDto) {

        return paymentRepository.save(requestDto.toEntity(pu.createUniqueId())).getTid();
    }

    @Transactional
    public Long update(Long payNo, PaymentUpdateRequestDto requestDto) {
        Payment payment = paymentRepository.findById(payNo).orElseThrow(() ->
                new IllegalArgumentException("해당 결제건이 없습니다. payNo = " + payNo));
//        payments.update(requestDto.getPayAmt());
        return payNo;
    }

    public PaymentResponseDto findById(Long payNo) {
        Payment entity = paymentRepository.findById(payNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 결제건이 없습니다. payNo = " + payNo));
        return new PaymentResponseDto(entity);
    }

//    @Transactional
//    public List<PaymentListResponseDto> findAllDesc() {
//        return paymentRepository.findAllDesc().stream()
//                .map(PaymentListResponseDto::new)
//                .collect(Collectors.toList());
//    }

}
