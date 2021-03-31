package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioService service;

    @Test
    public void deveSalvarUsuario() {
        Cliente usuario = new Cliente(2L, "Igor", "igor@igor", "12312312312", "123");
        Cliente usuarioRetornado = service.save(usuario);

        assertEquals(usuario, usuarioRetornado);
    }

    @Test
    void InsereEConsulta() {
        Cliente usuario = new Cliente(1L, "Igor", "igor@igor", "12312312312", "123");
        Cliente usuarioRetornado = service.save(usuario);
        assertEquals(usuario, usuarioRetornado);
    }

}