package team.college.payment.service;

import team.college.payment.model.Payment;

public interface PaymentService {
    public void addPayment(Payment payment);
    public void removePayment(Integer payment_id);
}
