package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.review.Review;
import com.soft.buserapp.model.review.ReviewRepository;
import com.soft.buserapp.model.usuario.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    public Optional<Review> findById(Long id){
        return this.repository.findById(id);
    }

    public Review save(Review review) {
        return this.repository.save(review);
    }

    public List<Review> findAll(){
        return this.repository.findAll();
    }

    public List<Review> findByCliente(Cliente cliente) {
        return this.repository.findAllByCliente(cliente);
    }

    public List<Review> findByEmpresa(Empresa empresa) {
        return this.repository.findAllByEmpresa(empresa);
    }

}
