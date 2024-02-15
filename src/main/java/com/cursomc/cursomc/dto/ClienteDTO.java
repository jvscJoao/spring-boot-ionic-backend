package com.cursomc.cursomc.dto;

import org.hibernate.validator.constraints.Length;

import com.cursomc.cursomc.domain.Cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record ClienteDTO(
    Integer id,
    
    @NotEmpty(message = "Preenchimento obrigatório") 
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    String nome,

    @NotEmpty(message = "Preenchimento obrigatório") 
    @Email
    String email
) {
    public ClienteDTO(Cliente c) {
        this(c.getId(), c.getNome(), c.getEmail());
    }
}
