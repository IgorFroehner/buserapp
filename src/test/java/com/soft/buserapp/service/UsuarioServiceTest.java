package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioService service;

    @Test
    public void deveSalvarUsuario() {
        Usuario usuario = new Usuario(2L, "Igor", "igor@igor", "12312312312", "123");
        Usuario usuarioRetornado = service.save(usuario);

        assertEquals(usuario, usuarioRetornado);
    }

    @Test
    void InsereEConsulta() {
        Usuario usuario = new Usuario(1L, "Igor", "igor@igor", "12312312312", "123");
        Usuario usuarioRetornado = service.save(usuario);
        assertEquals(usuario, usuarioRetornado);
    }

    @Test
    void deveSalvarVariosUsuarios() {
        Usuario usuario1 = new Usuario(5L, "Igor", "igor@igor", "12312312312", "123");
        Usuario usuario2 = new Usuario(2L, "Igor", "igor@igor", "12312312312", "123");
        Usuario usuario3 = new Usuario(3L, "Igor", "igor@igor", "12312312312", "123");
        Usuario usuario4 = new Usuario(4L, "Igor", "igor@igor", "12312312312", "123");

        List<Usuario> usuarios = new ArrayList<Usuario>(List.of(usuario1, usuario2, usuario3, usuario4));
        service.save(usuario1);
        service.save(usuario2);
        service.save(usuario3);
        service.save(usuario4);

        List<Usuario> usuariosRetornados = service.findAll();
        assertIterableEquals(usuarios, usuariosRetornados);
    }

}