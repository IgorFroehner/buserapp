package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    @Test
    public void deveSalvarCliente() {
        Cliente igor = new Cliente("Igor", "igor@igor", "12312312312", "123");
        Cliente usuarioRetornado = service.save(igor);
        assertEquals(igor, usuarioRetornado);
    }

    @Test
    void deveValidarCliente() {
        Cliente joao = new Cliente("Joao", "joao@joao", "12312312312", "11111111111");
        Cliente igor = new Cliente("Igor", "igor@igor", "12312312312", "123");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.save(joao));
        Assertions.assertDoesNotThrow(() -> service.save(igor));
    }

}