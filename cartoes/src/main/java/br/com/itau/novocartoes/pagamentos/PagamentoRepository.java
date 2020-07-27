package br.com.itau.novocartoes.pagamentos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    List<Pagamento> findByCartaoId(Integer cartaoId);
}
