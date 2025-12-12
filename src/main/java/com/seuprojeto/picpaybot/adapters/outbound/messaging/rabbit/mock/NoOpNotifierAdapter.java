package com.seuprojeto.picpaybot.adapters.outbound.messaging.rabbit.mock;

import org.springframework.stereotype.Component;
import com.seuprojeto.picpaybot.domain.ports.out.NotifierPort;
import com.seuprojeto.picpaybot.domain.model.Cliente;

@Component
public class NoOpNotifierAdapter implements NotifierPort {

    @Override
    public void notifyAccountOpened(Cliente cliente, String detalhe) {
        System.out.println("[NoOpNotifier] CPF=" + cliente.getCpf() + " | " + detalhe);
    }
}


