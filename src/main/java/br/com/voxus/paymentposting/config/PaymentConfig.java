package br.com.voxus.paymentposting.config;

import br.com.voxus.paymentposting.entities.Payment;
import br.com.voxus.paymentposting.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Calendar;

@Configuration
@Profile("test")
public class PaymentConfig implements CommandLineRunner {

    @Autowired
    private PaymentRepository repository;
    @Override
    public void run(String... args) throws Exception {
        Calendar c = Calendar.getInstance();
        String[] coments = new String[10];

        Payment payment = new Payment(null, "Teste", 200, c, coments);
        Payment payment1 = new Payment(null, "Teste", 200, c, coments);
        Payment payment2 = new Payment(null, "Teste", 200, c, coments);

        repository.saveAll(Arrays.asList(payment, payment1, payment2));
    }
}
