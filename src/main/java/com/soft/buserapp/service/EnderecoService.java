package com.soft.buserapp.service;

import com.soft.buserapp.model.endereco.Endereco;
import com.soft.buserapp.model.endereco.EnderecoRepository;
import com.soft.buserapp.model.linha.Linha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository repository;

    public Optional<Endereco> findById(Long id){
        return this.repository.findById(id);
    }

    public Endereco save(Endereco endereco) {
        return this.repository.save(endereco);
    }

    public void delete(Endereco endereco) {this.repository.delete(endereco);}

    public List<Endereco> findAll(){
        return this.repository.findAll();
    }

    public List<Endereco> enderecosDaLinha(Linha linha) {
        return this.repository.findAllByLinha(linha);
    }
}
