package com.geovanni.restaurante.listener;

import com.geovanni.restaurante.event.PedidoEvento;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {
    @EventListener
    public void ouvirEvento(PedidoEvento evento) {
        System.out.println("📢 Notificação enviada: " + evento.getMensagem());
    }
}
