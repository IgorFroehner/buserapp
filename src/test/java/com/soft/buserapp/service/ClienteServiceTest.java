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
        Cliente cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        Cliente retorno = service.save(cliente);
        assertEquals(cliente, retorno);
    }

    @Test
    void deveBuscarCliente() {
        var cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(cliente);
        var retorno = service.findById(cliente.getId());
        assertTrue(retorno.isPresent());
        assertEquals(cliente, retorno.get());
    }

    @Test
    void deveBuscarClientes() {
        var cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(cliente);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarCliente() {
        var cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(cliente);
        cliente.setCpf(999999999L);
        service.save(cliente);
        var retorno = service.findById(cliente.getId());
        assertTrue(retorno.isPresent());
        assertEquals(999999999L, retorno.get().getCpf());
    }

    @Test
    void deveValidarCliente() {
        Cliente joao = new Cliente("Joao", "joao@joao", "12312312312", 11111111111L);
        Cliente igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        assertThrows(IllegalArgumentException.class, () -> service.save(joao));
        assertDoesNotThrow(() -> service.save(igor));
    }

}