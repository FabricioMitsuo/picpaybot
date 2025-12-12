package com.seuprojeto.picpaybot.adapters.outbound.messaging.rabbit.mock;

import com.seuprojeto.picpaybot.domain.model.Cliente;
import com.seuprojeto.picpaybot.domain.ports.out.NotifierPort;
import org.springframework.stereotype.Component;


@Component
public class NoOpNotifierAdapter  implements  NotifierPort{

    @Override
    public void notifyAccountOpened(Cliente cliente, String detalhe) {
        // Implementação leve para desenvolvimento: apenas loga no console
        System.out.println("[NoOpNotifier] CPF=" + cliente.getCpf() + " - " + detalhe);
    }

}





