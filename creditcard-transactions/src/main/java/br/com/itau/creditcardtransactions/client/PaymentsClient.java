package br.com.itau.creditcardtransactions.client;

import br.com.itau.creditcardtransactions.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="payment-microservice", configuration = PaymentsClientConfiguration.class)
public interface PaymentsClient {
    @GetMapping("/pagamentos/{creditCardId}")
    List<Payment> listByCreditCardId(@PathVariable Long creditCardId);
}