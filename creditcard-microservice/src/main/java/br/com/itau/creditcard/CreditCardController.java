package br.com.itau.creditcard;

import br.com.itau.creditcard.model.CreditCard;
import br.com.itau.creditcard.model.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cartao")
public class CreditCardController {
    @Autowired
    public CreditCardService creditCardService;

    @Autowired
    private CreditCardMapper mapper;

    @Autowired
    private CustomerClient customerClient;

    @GetMapping("/{id}")
    public CreditCard findCreditCardByNumber(@PathVariable Long id) {
        return creditCardService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCreditCardResponse createCreditCard(@Valid @RequestBody CreateCreditCardRequest creditCardRequest) {
        Customer customer = customerClient.findCustomerById(creditCardRequest.getCustomerId()).orElseThrow(CustomerNotFoundException::new);

        CreditCard creditCard = creditCardService.create(creditCardRequest);

        CreateCreditCardResponse creditCardResponse = mapper.toCreateCreditCardResponse(creditCard);

        return creditCardResponse;
    }

    @PatchMapping("/{creditCardNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateCreditCardResponse updateCreditCard(@PathVariable String creditCardNumber, @RequestBody UpdateCreditCardRequest creditCardRequest) {
        creditCardRequest.setNumber(creditCardNumber);
        CreditCard creditCard = mapper.toCreditCard(creditCardRequest);

        creditCard = creditCardService.update(creditCard);

        return mapper.toUpdateCreditCardResponse(creditCard);
    }
}