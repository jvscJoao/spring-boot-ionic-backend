package com.cursomc.cursomc.dto;

import com.cursomc.cursomc.domain.Categoria;

public record CategoriaDTO(Integer id, String nome) {

    public CategoriaDTO(Categoria obj) {
        this(obj.getId(), obj.getNome());
    }
    
}
