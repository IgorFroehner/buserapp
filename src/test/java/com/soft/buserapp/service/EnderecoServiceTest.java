package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.endereco.Endereco;
import com.soft.buserapp.model.linha.Linha;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnderecoServiceTest {

    @Autowired private EnderecoService service;
    @Autowired private EmpresaService empresaService;
    @Autowired private LinhaService linhaService;

    private Endereco endereco;

    @BeforeEach
    void setUp() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        empresaService.save(empresa);
        linhaService.save(linha);
        endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        service.save(endereco);
    }

    @Test
    void deveCadastrarEndereco() {
        var enderecoRetornado = service.save(endereco);
        assertEquals(endereco, enderecoRetornado);
    }

    @Test
    void deveRemoverEndereco() {
        service.delete(endereco);
        assertTrue(service.findById(endereco.getId()).isEmpty());
    }

    @Test
    void deveBuscarEndereco() {
        var cliente = service.findById(endereco.getId());
        assertTrue(cliente.isPresent());
        assertEquals(endereco, cliente.get());
    }

    @Test
    void deveBuscarEmpresas() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        endereco.setRua("Blumenau");
        service.save(endereco);
        var empresa = service.findById(endereco.getId());
        assertTrue(empresa.isPresent());
        assertEquals("Blumenau", endereco.getRua());
    }

}