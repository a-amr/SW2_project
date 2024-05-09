package team.college.payment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import team.college.payment.model.*;
import team.college.payment.service.PaymentServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/payment")
public class PaymentController {
        // add payment
        // remove payment

        @Autowired
        private PaymentServiceImp paymentServiceImp;
        
        @PostMapping("/add")
        public void addPayment(@RequestBody Payment payment) {
                paymentServiceImp.addPayment(payment);
        }

        @GetMapping("/remove")
        public void removePayment(@RequestParam Integer payment_id) {
                paymentServiceImp.removePayment(payment_id);
        }
}
