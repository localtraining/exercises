package br.com.itau.novocartoes.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping(value="/cliente/{id}")
    public Cliente consultarCliente(@PathVariable Integer id) {
        return clienteRepo.findById(id).orElse(new Cliente());
    }

    @PostMapping(value="/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteRepo.save(cliente);
    }
}