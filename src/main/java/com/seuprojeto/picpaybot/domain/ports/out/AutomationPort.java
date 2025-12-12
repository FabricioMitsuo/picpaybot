package com.seuprojeto.picpaybot.domain.ports.out;

import com.seuprojeto.picpaybot.domain.model.Cliente;

public interface AutomationPort {
    boolean abrirConta(Cliente cliente);
}
