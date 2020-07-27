package br.com.itau.novocartoes.pagamentos;

import br.com.itau.novocartoes.cartao.Cartao;
import br.com.itau.novocartoes.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoController {
    @Autowired
    private CartaoRepository cartaoRepo;

    @Autowired
    private PagamentoRepository pagamentoRepo;

    @GetMapping(value="/pagamentos/{idCartao}")
    public List<Pagamento> consultarPagamentosCartao(@PathVariable Integer idCartao) {
        return pagamentoRepo.findByCartaoId(idCartao);
    }

    @PostMapping(value="/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento inserirPagamento(@RequestBody Pagamento pagamento) {
        Cartao cartao = cartaoRepo.findById(pagamento.getCartaoId()).orElse(null);
        Pagamento novoPagamento = new Pagamento();

        if(cartao != null) {
            pagamento.setCartaoId(cartao.getId());

            novoPagamento = pagamentoRepo.save(pagamento);
        }

        return novoPagamento;
    }
}