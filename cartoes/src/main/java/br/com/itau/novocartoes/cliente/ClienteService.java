package br.com.itau.novocartoes.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepo;

    public Cliente consultarCliente(Integer idCliente) {
        return clienteRepo.findById(idCliente).orElse(new Cliente());
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }
}
