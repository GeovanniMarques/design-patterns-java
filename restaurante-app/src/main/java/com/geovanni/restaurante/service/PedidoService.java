package com.geovanni.restaurante.service;

import com.geovanni.restaurante.event.PedidoEvento;
import com.geovanni.restaurante.model.Pedido;
import com.geovanni.restaurante.repository.PedidoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ApplicationEventPublisher publisher;

    public PedidoService(PedidoRepository pedidoRepository, ApplicationEventPublisher publisher) {
        this.pedidoRepository = pedidoRepository;
        this.publisher = publisher;
    }

    public Pedido criarPedido(String prato) {
        Pedido novoPedido = new Pedido(prato);
        Pedido pedidoCriado = pedidoRepository.save(novoPedido);

        // Publica um evento ao criar o pedido
        publisher.publishEvent(new PedidoEvento(this, "Novo pedido criado: " + pedidoCriado.getPrato()));

        return pedidoCriado;
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido atualizarStatusPedido(Long id, String novoStatus) {
        Optional<Pedido> pedidoOpt = pedidoRepository.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.atualizarStatus(novoStatus);
            Pedido pedidoAtualizado = pedidoRepository.save(pedido);

            // Publica um evento ao atualizar o status do pedido
            publisher.publishEvent(new PedidoEvento(this, "Pedido " + id + " atualizado para: " + novoStatus));

            return pedidoAtualizado;
        }
        throw new RuntimeException("Pedido não encontrado");
    }
}
