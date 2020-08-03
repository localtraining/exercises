package br.com.itau.creditcardtransactions.controller;

import br.com.itau.creditcardtransactions.model.dto.CreditCardTransactionsResponse;
import br.com.itau.creditcardtransactions.service.CreditCardTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fatura")
public class CreditCardTransactionsController {
    @Autowired
    private CreditCardTransactionsService creditCardTransactionsService;

    @GetMapping(value="/{clientId}/{creditCardId}")
    public List<CreditCardTransactionsResponse> listByCustomerIdAndCreditCardID(@PathVariable Long customerId, @PathVariable Long creditCardId) {
        return creditCardTransactionsService.findCreditCardCustomerById(customerId, creditCardId);
    }
}