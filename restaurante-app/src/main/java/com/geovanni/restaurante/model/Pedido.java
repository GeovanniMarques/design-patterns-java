package com.geovanni.restaurante.model;

import jakarta.persistence.*;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prato;
    private String status;

    public Pedido() {
        this.status = "Recebido";
    }

    public Pedido(String prato) {
        this.prato = prato;
        this.status = "Recebido";
    }

    public Long getId() { return id; }
    public String getPrato() { return prato; }
    public String getStatus() { return status; }

    public void atualizarStatus(String novoStatus) {
        this.status = novoStatus;
    }
}
