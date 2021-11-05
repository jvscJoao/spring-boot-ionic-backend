package com.projetoestudos.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetoestudos.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
