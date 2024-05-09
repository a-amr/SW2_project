package team.college.database.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import team.college.database.model.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
