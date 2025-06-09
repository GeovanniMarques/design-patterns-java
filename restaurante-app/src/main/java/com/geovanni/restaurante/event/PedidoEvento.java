package com.geovanni.restaurante.event;

import org.springframework.context.ApplicationEvent;

public class PedidoEvento extends ApplicationEvent {
    private final String mensagem;

    public PedidoEvento(Object source, String mensagem) {
        super(source);
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
