package br.com.voxus.paymentposting.services;

import br.com.voxus.paymentposting.entities.Payment;
import br.com.voxus.paymentposting.repositories.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private PaymentRepository repository;

    public List<Payment> findAllPayments(){
        return repository.findAll();
    }

    public Payment findPayment(Long id){
        Optional<Payment> obj = repository.findById(id);
        return obj.get();
    }

    public Payment savePayment(Payment obj){
        return repository.save(obj);
    }

    public void deletePayment(Long id){
        repository.deleteById(id);
    }

    public Payment editPayment(Long id, Payment obj){
        Payment entity = repository.getOne(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(Payment entity, Payment obj){
        entity.setTitle(obj.getTitle());
        entity.setValue(obj.getValue());
        entity.setDate(obj.getDate());
        entity.setComments(obj.getComments());
    }

}
