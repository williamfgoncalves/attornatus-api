package com.example.attornatusapi.web;

import com.example.attornatusapi.dto.ClienteDTO;
import com.example.attornatusapi.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClienteDTO> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClienteDTO getById(@PathVariable final Long id) {
        return clienteService.consultarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criar(@RequestBody final ClienteDTO clienteDTO) {
        clienteService.criar(clienteDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void alterar(@PathVariable final Long id, @RequestBody final ClienteDTO clienteDTO){
        clienteService.alterar(id, clienteDTO);
    }
}
