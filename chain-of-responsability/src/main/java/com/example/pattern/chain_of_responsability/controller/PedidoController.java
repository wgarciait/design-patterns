package com.example.pattern.chain_of_responsability.controller;

import com.example.pattern.chain_of_responsability.dto.Pedido;
import com.example.pattern.chain_of_responsability.service.PedidoChainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoChainService pedidoChainService;

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        pedidoChainService.processarPedido(pedido);
        return ResponseEntity.ok("Pedido " + pedido.id() + " processado com sucesso!");
    }
}
