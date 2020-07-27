package br.com.itau.novocartoes.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartaoController {
    @Autowired
    public CartaoService cartaoService;

    @GetMapping(value="/cartao/{id}")
    public Cartao consultarCliente(@PathVariable Integer id) {
        return cartaoService.consultarCartao(id);
    }

    @PostMapping(value="/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao criarCartao(@RequestBody Cartao cartao) {
        return cartaoService.salvarCartao(cartao);
    }

    @PatchMapping(value="/cartao/{numeroCartao}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao ativarCartao(@PathVariable String numeroCartao) {
        return cartaoService.ativarCartao(numeroCartao);
    }
}