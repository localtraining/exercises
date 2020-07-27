package br.com.itau.novocartoes.cliente;

import br.com.itau.novocartoes.cartao.Cartao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty(value="id")
    private Integer clienteId;

    @Column
    @JsonProperty(value="name")
    private String nome;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteid")
    @JsonIgnore
    private Set<Cartao> cartoes;

    public Cliente() {
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Cartao> getCartoes() {
        return cartoes;
    }

    public void setCartoes(Set<Cartao> cartoes) {
        this.cartoes = cartoes;
    }
}