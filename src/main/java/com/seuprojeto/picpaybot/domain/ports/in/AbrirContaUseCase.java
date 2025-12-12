package com.seuprojeto.picpaybot.domain.ports.in;

import com.seuprojeto.picpaybot.domain.model.Cliente;

public interface AbrirContaUseCase {
    void executar(Cliente cliente);
}
