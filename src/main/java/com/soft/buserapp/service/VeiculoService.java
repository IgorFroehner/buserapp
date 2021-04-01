package com.soft.buserapp.service;

import com.soft.buserapp.model.veiculo.Veiculo;
import com.soft.buserapp.model.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    VeiculoRepository repository;

    public Optional<Veiculo> findById(Long id){
        return this.repository.findById(id);
    }

    public Veiculo save(Veiculo veiculo) {
        return this.repository.save(veiculo);
    }

    public List<Veiculo> findAll(){
        return this.repository.findAll();
    }
}