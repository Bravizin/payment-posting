package br.com.voxus.paymentposting.repositories;

import br.com.voxus.paymentposting.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
