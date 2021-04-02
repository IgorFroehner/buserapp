package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LinhaServiceTest {

    @Autowired
    private LinhaService service;

    @Autowired
    private EmpresaService empresaService;

    private final Empresa empresa = new Empresa("EmpresaTeste", "teste@teste.com", "123", 123L);;

    @BeforeEach
    void setUp() {
        empresaService.save(empresa);
    }

    @Test
    public void deveSalvarLinha() {
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        var retorno = service.save(linha);
        assertEquals(linha, retorno);
    }

    @Test
    void deveBuscarLinha() {
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        service.save(linha);
        var retorno = service.findById(linha.getId());
        assertTrue(retorno.isPresent());
        assertEquals(linha, retorno.get());
    }

    @Test
    void deveBuscarLinhas() {
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        service.save(linha);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarLinha() {
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.50"));
        service.save(linha);
        linha.setPreco(BigDecimal.ZERO);
        service.save(linha);
        var retorno = service.findById(linha.getId());
        assertTrue(retorno.isPresent());
        assertEquals(0, BigDecimal.ZERO.compareTo(retorno.get().getPreco()));
    }
}
