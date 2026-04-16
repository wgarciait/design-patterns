package com.example.pattern.chain_of_responsability.handler.impl;

import com.example.pattern.chain_of_responsability.dto.Pedido;
import com.example.pattern.chain_of_responsability.exception.ProcessamentoPedidoException;
import com.example.pattern.chain_of_responsability.handler.PedidoHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ValidarEstoqueHandler implements PedidoHandler {
    @Override
    public void processar(Pedido pedido) {
        // Exemplo de lógica de interrupção
        if (pedido.itens().isEmpty()) {
            throw new ProcessamentoPedidoException("Estoque insuficiente: pedido sem itens.");
        }
        System.out.println("Estoque validado com sucesso.");
    }

    @Override
    public boolean deveExecutar(Pedido pedido) {
        return true;
    }
}
