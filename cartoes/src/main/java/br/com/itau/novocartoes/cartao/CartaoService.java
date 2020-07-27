package br.com.itau.novocartoes.cartao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository cartaoRepo;

    public Cartao consultarCartao(Integer id) {
        Cartao cartaoConsulta = cartaoRepo.findById(id).orElse(new Cartao());
        cartaoConsulta.setAtivo(null);

        return cartaoConsulta;
    }

    public Cartao salvarCartao(Cartao cartao) {
        return cartaoRepo.save(cartao);
    }

    public Cartao ativarCartao(String numeroCartao) {
        Cartao cartaoAtivar = cartaoRepo.findByNumero(numeroCartao);

        if(cartaoAtivar != null) {
            cartaoAtivar.setAtivo(true);
        }

        return cartaoRepo.save(cartaoAtivar);
    }
}