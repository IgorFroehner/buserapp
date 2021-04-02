package com.soft.buserapp.model.review;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.usuario.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByCliente(Cliente cliente);
    List<Review> findAllByEmpresa(Empresa empresa);

}
