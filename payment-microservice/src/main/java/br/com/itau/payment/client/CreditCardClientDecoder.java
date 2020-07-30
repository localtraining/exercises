package br.com.itau.payment.client;

import br.com.itau.payment.exception.CreditCardNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CreditCardClientDecoder implements ErrorDecoder {
    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            throw new CreditCardNotFoundException();
        } else {
            return errorDecoder.decode(s, response);
        }
    }
}