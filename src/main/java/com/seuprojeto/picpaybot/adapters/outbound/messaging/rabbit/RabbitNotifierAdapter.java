package com.seuprojeto.picpaybot.adapters.outbound.messaging.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import com.seuprojeto.picpaybot.domain.ports.out.NotifierPort;
import com.seuprojeto.picpaybot.domain.model.Cliente;

@Component
public class RabbitNotifierAdapter implements NotifierPort {
    private final RabbitTemplate rabbitTemplate;
    private final String exchange = "picpay.exchange";
    private final String routingKey = "conta.aberta";

    public RabbitNotifierAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void notifyAccountOpened(Cliente cliente, String detalhe) {
        String msg = String.format("CPF:%s;NOME:%s;DETALHE:%s", cliente.getCpf(), cliente.getNomeCompleto(), detalhe);
        // exchange pode ser configurado; aqui usamos routing direto no template default
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
    }
}
