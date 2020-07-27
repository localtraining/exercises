package br.com.itau.novocartoes.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Integer> {
    public Cartao findByNumero(String numero);
}
