package com.seuprojeto.picpaybot.adapters.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String EXCHANGE = "picpay.exchange";
    public static final String QUEUE = "conta-aberta-queue";
    public static final String ROUTING_KEY = "conta.aberta";

    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE).durable(true).build();
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable(QUEUE).build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY).noargs();
    }
}
