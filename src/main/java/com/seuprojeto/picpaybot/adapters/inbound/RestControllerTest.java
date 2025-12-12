package com.seuprojeto.picpaybot.adapters.inbound;

import org.springframework.web.bind.annotation.*;
import com.seuprojeto.picpaybot.application.service.AbrirContaService;
import com.seuprojeto.picpaybot.domain.model.Cliente;

@RestController
@RequestMapping("/api/test")
public class RestControllerTest {
    private final AbrirContaService service;
    public RestControllerTest(AbrirContaService service) { this.service = service; }

    @PostMapping("/abrir-conta")
    public String abrirConta(@RequestBody Cliente cliente) {
        service.executar(cliente);
        return "Processo iniciado";
    }
}
