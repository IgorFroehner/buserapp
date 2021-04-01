package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
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
        Cliente igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        Cliente usuarioRetornado = service.save(igor);
        assertEquals(igor, usuarioRetornado);
    }

    @Test
    void deveBuscarCliente() {
        var igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(igor);
        var cliente = service.findById(igor.getId());
        assertTrue(cliente.isPresent());
        assertEquals(igor, cliente.get());
    }

    @Test
    void deveBuscarClientes() {
        var igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(igor);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarCliente() {
        var igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(igor);
        igor.setCpf(999999999L);
        service.save(igor);
        var cliente = service.findById(igor.getId());
        assertTrue(cliente.isPresent());
        assertEquals(999999999L, cliente.get().getCpf());
    }

    @Test
    void deveValidarCliente() {
        Cliente joao = new Cliente("Joao", "joao@joao", "12312312312", 11111111111L);
        Cliente igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        assertThrows(IllegalArgumentException.class, () -> service.save(joao));
        assertDoesNotThrow(() -> service.save(igor));
    }

}