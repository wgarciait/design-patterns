package com.example.pattern.chain_of_responsability.handler.impl;

import com.example.pattern.chain_of_responsability.dto.Pedido;
import com.example.pattern.chain_of_responsability.exception.ProcessamentoPedidoException;
import com.example.pattern.chain_of_responsability.handler.PedidoHandler;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Order(2)
public class ValidarPagamentoHandler implements PedidoHandler {
    @Override
    public void processar(Pedido pedido) {
        // Exemplo de lógica de interrupção
        if (!pedido.pago() || BigDecimal.ZERO.equals(pedido.valor())) {
            throw new ProcessamentoPedidoException("Pagamento pendente.");
        }
        System.out.println("Pagamento validado com sucesso.");
    }

    @Override
    public boolean deveExecutar(Pedido pedido) {
        return true;
    }
}
