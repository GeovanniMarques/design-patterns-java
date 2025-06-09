package com.geovanni.restaurante.controller;

import com.geovanni.restaurante.model.Pedido;
import com.geovanni.restaurante.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestParam String prato) {
        Pedido pedido = pedidoService.criarPedido(prato);
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listarPedidos() {
        return ResponseEntity.ok(pedidoService.listarPedidos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.buscarPedidoPorId(id);
        return pedido.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Long id, @RequestParam String novoStatus) {
        try {
            Pedido pedidoAtualizado = pedidoService.atualizarStatusPedido(id, novoStatus);
            return ResponseEntity.ok(pedidoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
