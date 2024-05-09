package team.college.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.college.database.model.entity.*;
import team.college.database.model.repository.*;

@Service
public class PaymentService {

        @Autowired
        private PaymentRepository paymentRepository;

        @Autowired
        private UserRepository userRepository;

        public Boolean add(Payment payment) {
                if (payment.getMethod() == null) return false;
                if (payment.getMethod().isEmpty()) return false;
                if (payment.getPrice() == null || payment.getPrice() <= 0) return false;
                if (payment.getUser() == null) return false;
                if (!userRepository.findById(payment.getUser().getId()).isPresent()) return false;
                paymentRepository.save(payment);
                return true;
        }

        public Boolean remove(Integer payment_id) {
                if (paymentRepository.findById(payment_id).isPresent())
                {
                        paymentRepository.deleteById(payment_id);
                        return true;
                }
                return false;
        }
        
}
