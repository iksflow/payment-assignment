package com.iksflow.payment.web;

import com.iksflow.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PaymentService paymentService;

    @GetMapping("/")
    public String index(Model model) {
//        model.addAttribute("payments", paymentService.findAllDesc());
        return "index";
    }

    @GetMapping("/payments/save")
    public String paymentsSave() {
        return "payments-save";
    }
}
