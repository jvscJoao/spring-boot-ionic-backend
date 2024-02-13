package com.cursomc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.cursomc.domain.Cliente;
import com.cursomc.cursomc.exceptions.ObjectNotFoundException;
import com.cursomc.cursomc.repositories.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;
    
    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não enxontrado! ID: " + id + ", Tipo: " + Cliente.class.getName()
        ));
    }
}
