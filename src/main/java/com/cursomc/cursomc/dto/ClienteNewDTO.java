package com.cursomc.cursomc.dto;

import org.hibernate.validator.constraints.Length;

import com.cursomc.cursomc.validation.ClienteInsert;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@ClienteInsert
public record ClienteNewDTO(
    @NotEmpty(message = "Preenchimento obrigatório") 
    @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    String nome,

    @NotEmpty(message = "Preenchimento obrigatório") 
    @Email(message="Email inválido")
    String email,
    
    @NotEmpty(message = "Preenchimento obrigatório") 
    String cpfOuCnpj,

    Integer tipo,
    
    @NotEmpty(message = "Preenchimento obrigatório") 
    String senha,

    @NotEmpty(message = "Preenchimento obrigatório") 
    String logradouro,

    @NotEmpty(message = "Preenchimento obrigatório") 
    String numero,

    String complemento,

    String bairro,

    @NotEmpty(message = "Preenchimento obrigatório") 
    String cep,

    @NotEmpty(message = "Preenchimento obrigatório") 
    String telefone1,

    String telefone2,
    String telefone3,

    Integer cidadeId
) {

}
