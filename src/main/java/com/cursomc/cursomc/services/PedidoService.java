package com.cursomc.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursomc.cursomc.domain.Pedido;
import com.cursomc.cursomc.exceptions.ObjectNotFoundException;
import com.cursomc.cursomc.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;
    
    public Pedido buscar(Integer id) {
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
            "Objeto não enxontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()
        ));
    }
}
