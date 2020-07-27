package br.com.itau.novocartoes.pagamentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(value="/pagamentos/{idCartao}")
    public List<Pagamento> consultarPagamentosCartao(@PathVariable Integer idCartao) {
        return pagamentoService.localizarPagamentoPorIdCartao(idCartao);
    }

    @PostMapping(value="/pagamento")
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento inserirPagamento(@RequestBody Pagamento pagamento) {
        return pagamentoService.inserirNovoPagamento(pagamento);
    }
}