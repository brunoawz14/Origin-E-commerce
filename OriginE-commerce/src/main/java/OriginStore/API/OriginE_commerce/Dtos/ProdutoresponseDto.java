package OriginStore.API.OriginE_commerce.Dtos;

import java.math.BigDecimal;

public record ProdutoresponseDto(Long id, String nome, BigDecimal preco, Integer estoque) {}