package com.iksflow.payment.domain.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    @Query(value = "SELECT * FROM Payments", nativeQuery = true)
//    List<Payment> findAllDesc();
}
