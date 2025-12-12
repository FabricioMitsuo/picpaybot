package com.seuprojeto.picpaybot.domain.ports.out;

import com.seuprojeto.picpaybot.domain.model.Cliente;

public interface NotifierPort {
    void notifyAccountOpened(Cliente cliente, String detalhe);
}
