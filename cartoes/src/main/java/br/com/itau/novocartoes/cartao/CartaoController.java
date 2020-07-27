package br.com.itau.novocartoes.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartaoController {
    @Autowired
    private CartaoRepository cartaoRepo;

    @GetMapping(value="/cartao/{id}")
    public Cartao consultarCliente(@PathVariable Integer id) {
        Cartao cartaoConsulta = cartaoRepo.findById(id).orElse(new Cartao());
        cartaoConsulta.setAtivo(null);

        return cartaoConsulta;
    }

    @PostMapping(value="/cartao")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao criarCartao(@RequestBody Cartao cartao) {
        return cartaoRepo.save(cartao);
    }

    @PatchMapping(value="/cartao/{numero}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao ativarCartao(@PathVariable String numero) {
        Cartao cartaoAtivar = cartaoRepo.findByNumero(numero);

        if(cartaoAtivar != null) {
            cartaoAtivar.setAtivo(true);
        }

        return cartaoRepo.save(cartaoAtivar);
    }
}