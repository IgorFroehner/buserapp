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

    @Autowired
    private EnderecoService service;

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private LinhaService linhaService;

    Empresa empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
    Linha linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));

    @BeforeEach
    void setUp() {
        empresaService.save(empresa);
        linhaService.save(linha);
    }

    @Test
    void deveCadastrarEndereco() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        var enderecoRetornado = service.save(endereco);
        assertEquals(endereco, enderecoRetornado);
    }

    @Test
    void deveBuscarEndereco() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        service.save(endereco);
        var cliente = service.findById(endereco.getId());
        assertTrue(cliente.isPresent());
        assertEquals(endereco, cliente.get());
    }

    @Test
    void deveBuscarEmpresas() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        service.save(endereco);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        service.save(endereco);
        endereco.setRua("Blumenau");
        service.save(endereco);
        var empresa = service.findById(endereco.getId());
        assertTrue(empresa.isPresent());
        assertEquals("Blumenau", endereco.getRua());
    }

}