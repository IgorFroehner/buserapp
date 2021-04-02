package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
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

    public void adicionaVeiculoNaLinha(Veiculo veiculo, Linha linha) {
        veiculo.setLinha(linha);
        repository.save(veiculo);
    }

    public List<Veiculo> veiculosDaEmpresa(Empresa empresa) {
        return this.repository.findAllByEmpresa(empresa);
    }

    public List<Veiculo> veiculosDaLinha(Linha linha) {
        return this.repository.findAllByLinha(linha);
    }
}
