package br.com.itau.novocartoes.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value="/cliente/{id}")
    public Cliente consultarCliente(@PathVariable Integer id) {
        return clienteService.consultarCliente(id);
    }

    @PostMapping(value="/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.salvarCliente(cliente);
    }
}