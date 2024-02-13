package com.cursomc.cursomc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursomc.cursomc.domain.Cliente;
import com.cursomc.cursomc.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
     
}
