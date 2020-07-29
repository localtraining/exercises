package br.com.itau.creditcard;

import br.com.itau.creditcard.model.CreditCard;
import br.com.itau.creditcard.model.dto.CreateCreditCardRequest;
import br.com.itau.creditcard.model.dto.CreditCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private CreditCardMapper mapper;

    public CreditCard create(CreateCreditCardRequest creditCardRequest) {
        CreditCard creditCard = mapper.toCreditCard(creditCardRequest);
        creditCard.setActive(false);

        return creditCardRepository.save(creditCard);
    }

    public CreditCard update(CreditCard creditCard) {
        CreditCard savedCreditCard = findByNumber(creditCard.getNumber());

        savedCreditCard.setActive(creditCard.getActive());

        return creditCardRepository.save(savedCreditCard);
    }

    public CreditCard findByNumber(String number) {
        return creditCardRepository.findByNumber(number).orElseThrow(CreditCardNotFoundException::new);
    }

    public CreditCard findById(Long id) {
        return creditCardRepository.findById(id).orElseThrow(CreditCardNotFoundException::new);
    }
}