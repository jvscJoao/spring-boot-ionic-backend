package com.cursomc.cursomc.dto;

import org.hibernate.validator.constraints.Length;

import com.cursomc.cursomc.domain.Categoria;

import jakarta.validation.constraints.NotEmpty;

public record CategoriaDTO(
    Integer id, 
    @NotEmpty(message = "Preenchimento obrigatório") 
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    String nome
) {

    public CategoriaDTO(Categoria obj) {
        this(obj.getId(), obj.getNome());
    }

}
