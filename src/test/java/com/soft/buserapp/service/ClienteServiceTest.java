package com.soft.buserapp.service;

import com.soft.buserapp.model.usuario.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        service.save(cliente);
    }

    @Test
    public void deveSalvarCliente() {
        Cliente retorno = service.save(cliente);
        assertEquals(cliente, retorno);
    }

    @Test
    void deveBuscarCliente() {
        var retorno = service.findById(cliente.getId());
        assertTrue(retorno.isPresent());
        assertEquals(cliente, retorno.get());
    }

    @Test
    void deveBuscarClientes() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarCliente() {
        cliente.setCpf(999999999L);
        service.save(cliente);
        var retorno = service.findById(cliente.getId());
        assertTrue(retorno.isPresent());
        assertEquals(999999999L, retorno.get().getCpf());
    }

    @Test
    void deveValidarCliente() {
        var joao = new Cliente("Joao", "joao@joao", "12312312312", 11111111111L);
        var igor = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        assertThrows(IllegalArgumentException.class, () -> service.save(joao));
        assertDoesNotThrow(() -> service.save(igor));
    }

}