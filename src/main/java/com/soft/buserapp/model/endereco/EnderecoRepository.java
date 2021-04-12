package com.soft.buserapp.model.endereco;

import com.soft.buserapp.model.linha.Linha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    List<Endereco> findAllByLinha(Linha linha);

}
