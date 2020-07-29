package br.com.itau.payment;

import br.com.itau.payment.model.dto.PaymentMapper;
import br.com.itau.payment.model.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentMapper paymentMapper;

    @GetMapping(value="/pagamentos/{creditCardId}")
    public List<Payment> listByCreditCardId(@PathVariable Long creditCardId) {
        return paymentService.listByCreditCardId(creditCardId);
    }

    @PostMapping(value="/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Payment create(@Valid @RequestBody PaymentRequest paymentRequest) {
        Payment payment = paymentMapper.toPayment(paymentRequest);

        return paymentService.create(payment);
    }
}