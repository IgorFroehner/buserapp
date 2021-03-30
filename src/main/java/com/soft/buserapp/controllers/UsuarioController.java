package com.soft.buserapp.controllers;

import com.soft.buserapp.model.usuario.Usuario;
import com.soft.buserapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String getNomeById(){
        return service.findById(1L).map(Usuario::getNome).orElseGet(() -> "usuario não encontrado");
    }

}
