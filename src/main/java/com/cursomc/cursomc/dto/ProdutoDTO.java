package com.cursomc.cursomc.dto;

import com.cursomc.cursomc.domain.Produto;

public record ProdutoDTO(
    Integer id, 
    String nome,
    Double preco
) {

    public ProdutoDTO(Produto obj) {
        this(obj.getId(), obj.getNome(), obj.getPreco());
    }

}
