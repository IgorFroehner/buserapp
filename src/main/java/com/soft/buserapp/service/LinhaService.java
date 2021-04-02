package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
import com.soft.buserapp.model.linha.LinhaRepository;
import com.soft.buserapp.model.veiculo.Veiculo;
import com.soft.buserapp.model.veiculo.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LinhaService {

    @Autowired
    LinhaRepository repository;

    @Autowired
    VeiculoRepository veiculoRepository;

    public Optional<Linha> findById(Long id){
        return this.repository.findById(id);
    }

    public Linha save(Linha linha) {
        return this.repository.save(linha);
    }

    public List<Linha> findAll(){
        return this.repository.findAll();
    }

    public void adicionaOnibusLinha(Linha linha, Veiculo veiculo) {
        veiculo.setLinha(linha);
        veiculoRepository.save(veiculo);
    }

    public List<Linha> linhasDaEmpresa(Empresa empresa) {
        return this.repository.findAllByEmpresa(empresa);
    }
}
