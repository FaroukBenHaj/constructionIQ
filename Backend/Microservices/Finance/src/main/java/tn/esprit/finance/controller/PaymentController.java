package tn.esprit.finance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.finance.entity.Payment;
import tn.esprit.finance.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
//@RequiredArgsConstructor
public class PaymentController {
    @Autowired
    private  PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> processPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.processPayment(payment));
    }

}
