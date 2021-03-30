package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Usuario;
import com.soft.buserapp.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public Optional<Usuario> findById(Long id){
        return this.repository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return this.repository.save(usuario);
    }

    public List<Usuario> findAll(){
        return this.repository.findAll();
    }




}
