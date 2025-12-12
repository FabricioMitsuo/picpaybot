package com.seuprojeto.picpaybot.application.service;

import org.springframework.stereotype.Service;
import com.seuprojeto.picpaybot.domain.model.Cliente;
import com.seuprojeto.picpaybot.domain.ports.in.AbrirContaUseCase;
import com.seuprojeto.picpaybot.domain.ports.out.AutomationPort;
import com.seuprojeto.picpaybot.domain.ports.out.NotifierPort;

@Service
public class AbrirContaService implements AbrirContaUseCase {

    private final AutomationPort automation;
    private final NotifierPort notifier;

    public AbrirContaService(AutomationPort automation, NotifierPort notifier) {
        this.automation = automation;
        this.notifier = notifier;
    }

    @Override
    public void executar(Cliente cliente) {
        boolean sucesso = automation.abrirConta(cliente);
        if (sucesso) {
            notifier.notifyAccountOpened(cliente, "Conta aberta com sucesso");
        } else {
            notifier.notifyAccountOpened(cliente, "Falha ao abrir conta");
        }
    }
}
