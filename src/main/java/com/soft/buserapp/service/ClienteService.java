package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
import com.soft.buserapp.model.usuario.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Optional<Cliente> findById(Long id){
        return this.repository.findById(id);
    }

    public static boolean validaCpf(String cpf) {
        return !cpf.equals("11111111111");
    }

    public Cliente save(Cliente usuario) {
        if (!validaCpf(usuario.getCpf())) throw new IllegalArgumentException("CPF Invalido");
        return this.repository.save(usuario);
    }

    public List<Cliente> findAll(){
        return this.repository.findAll();
    }




}
