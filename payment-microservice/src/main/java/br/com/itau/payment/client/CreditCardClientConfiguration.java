package br.com.itau.payment.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CreditCardClientConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CreditCardClientDecoder();
    }
}