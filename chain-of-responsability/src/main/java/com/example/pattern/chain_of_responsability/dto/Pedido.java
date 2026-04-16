package com.example.pattern.chain_of_responsability.dto;

import java.math.BigDecimal;
import java.util.List;

public record Pedido(
        String id,
        List<String> itens,
        BigDecimal valor,
        boolean pago
) {}
