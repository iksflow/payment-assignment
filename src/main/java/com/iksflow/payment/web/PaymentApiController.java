package com.iksflow.payment.web;

import com.iksflow.payment.service.PaymentService;
import com.iksflow.payment.web.dto.PaymentSaveRequestDto;
import com.iksflow.payment.web.dto.PaymentUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PaymentApiController {

    private final PaymentService paymentService;

    @PostMapping("/api/v1/payment")
    public String save(@RequestBody PaymentSaveRequestDto requestDto) {
        return paymentService.save(requestDto);
    }

    @PutMapping("/api/v1/payment/{payNo}")
    public Long update(@PathVariable Long payNo, @RequestBody PaymentUpdateRequestDto requestDto) {
        return paymentService.update(payNo, requestDto);
    }
}
