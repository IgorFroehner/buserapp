package com.soft.buserapp.model.linha;

import com.soft.buserapp.model.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {

    List<Linha> findAllByEmpresa(Empresa empresa);

}
