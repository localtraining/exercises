package br.com.itau.payment.service;

import br.com.itau.payment.client.CreditCardClient;
import br.com.itau.payment.exception.CreditCardNotFoundException;
import br.com.itau.payment.repository.PaymentRepository;
import br.com.itau.payment.model.Payment;
import br.com.itau.payment.model.dto.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private CreditCardClient creditCardClient;

    public List<Payment> listByCreditCardId(Long creditCardId) {
        return paymentRepository.findByCreditCardId(creditCardId);
    }

    public Payment create(Payment payment) {
        CreditCard creditCard = creditCardClient.findCreditCardCustomerById(payment.getCreditCardId()).orElseThrow(CreditCardNotFoundException::new);

        return paymentRepository.save(payment);
    }
}