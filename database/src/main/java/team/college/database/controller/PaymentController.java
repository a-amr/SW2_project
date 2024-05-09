package team.college.database.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.college.database.model.entity.*;
import team.college.database.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("payment")
public class PaymentController {

        @Autowired
        private PaymentService paymentService;

        @PostMapping("add")
        public Payment addPayment(@RequestBody Payment payment) {
            paymentService.add(payment);
            return payment;
        }

        @GetMapping("remove")
        public void remove(@RequestParam Integer payment_id) {
            paymentService.remove(payment_id);
        }
        
        
}
