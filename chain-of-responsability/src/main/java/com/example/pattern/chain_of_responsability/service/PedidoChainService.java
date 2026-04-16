package com.example.pattern.chain_of_responsability.service;

import com.example.pattern.chain_of_responsability.dto.Pedido;
import com.example.pattern.chain_of_responsability.exception.ProcessamentoPedidoException;
import com.example.pattern.chain_of_responsability.handler.PedidoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoChainService {

    private final List<PedidoHandler> handlers;

    public void processarPedido(Pedido pedido) {
        try {
            for (var handler : handlers) {
                if (handler.deveExecutar(pedido)) {
                    handler.processar(pedido);
                }
            }
            System.out.println("Pedido processado com sucesso!");
        } catch (ProcessamentoPedidoException e) {
            System.err.println("Falha no processamento: " + e.getMessage());
            throw e;
        }
    }
}
