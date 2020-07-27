package br.com.itau.novocartoes.pagamentos;

import br.com.itau.novocartoes.cartao.Cartao;
import br.com.itau.novocartoes.cartao.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    @Autowired
    private CartaoRepository cartaoRepo;

    @Autowired
    private PagamentoRepository pagamentoRepo;

    public List<Pagamento> localizarPagamentoPorIdCartao(Integer idCartao) {
        return pagamentoRepo.findByCartaoId(idCartao);
    }

    public Pagamento inserirNovoPagamento(Pagamento pagamento) {
        Cartao cartao = cartaoRepo.findById(pagamento.getCartaoId()).orElse(null);
        Pagamento novoPagamento = new Pagamento();

        if(cartao != null) {
            pagamento.setCartaoId(cartao.getId());

            novoPagamento = pagamentoRepo.save(pagamento);
        }

        return novoPagamento;
    }
}