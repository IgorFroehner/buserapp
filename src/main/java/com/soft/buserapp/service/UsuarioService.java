package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
import com.soft.buserapp.model.usuario.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    ClienteRepository repository;

    public Optional<Cliente> findById(Long id){
        return this.repository.findById(id);
    }

    public Cliente save(Cliente usuario) {
        return this.repository.save(usuario);
    }

    public List<Cliente> findAll(){
        return this.repository.findAll();
    }




}
