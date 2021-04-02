package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.empresa.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository repository;

    public Optional<Empresa> findById(Long id){
        return this.repository.findById(id);
    }

    public Empresa save(Empresa empresa) {
        return this.repository.save(empresa);
    }

    public List<Empresa> findAll(){
        return this.repository.findAll();
    }


}
