package OriginStore.API.OriginE_commerce.Dtos;

import java.math.BigDecimal;

public record ProdutoDtos(
        String nome,
        String descricao,
        BigDecimal preco,
        Integer categoria
){

}
