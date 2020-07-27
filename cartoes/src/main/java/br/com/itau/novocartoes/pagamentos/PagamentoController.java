package br.com.itau.novocartoes.pagamentos;

import br.com.itau.novocartoes.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PagamentoController {
    @Autowired
    private PagamentoRepository pagamentoRepo;

    @GetMapping(value="/pagamentos/{idCartao}")
    public List<Pagamento> consultarPagamentosCartao(@PathVariable Integer idCartao) {
        return pagamentoRepo.findByCartaoId(idCartao);
    }
}