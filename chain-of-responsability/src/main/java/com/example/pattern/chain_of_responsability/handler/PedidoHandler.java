package com.example.pattern.chain_of_responsability.handler;

import com.example.pattern.chain_of_responsability.dto.Pedido;

public interface PedidoHandler {
    void processar(Pedido pedido);
    boolean deveExecutar(Pedido pedido);
}
