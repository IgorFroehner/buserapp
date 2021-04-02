package com.soft.buserapp.model.veiculo;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findAllByEmpresa(Empresa empresa);

    List<Veiculo> findAllByLinha(Linha linha);
}
