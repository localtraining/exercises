package br.com.itau.creditcard.client;

import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {
    @Bean
    public ErrorDecoder getErrorDecoder() {
        return new CustomerClientDecoder();
    }
}