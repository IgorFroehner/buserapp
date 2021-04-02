package com.soft.buserapp.service;

import com.soft.buserapp.model.endereco.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoService repository;

    public Optional<Endereco> findById(Long id){
        return this.repository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return this.repository.save(endereco);
    }

    public List<Endereco> findAll(){
        return this.repository.findAll();
    }
}
