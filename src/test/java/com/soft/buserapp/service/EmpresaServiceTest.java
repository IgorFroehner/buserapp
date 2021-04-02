package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
import com.soft.buserapp.model.veiculo.Veiculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmpresaServiceTest {

    @Autowired private EmpresaService service;
    @Autowired private VeiculoService veiculoService;
    @Autowired private LinhaService linhaService;

    private Empresa empresa;

    @BeforeEach
    void setUp() {
        empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(empresa);
    }

    @Test
    void deveCadastrarEmpresa() {
        var rotorno = service.save(empresa);
        assertEquals(empresa, rotorno);
    }

    @Test
    void deveBuscarEmpresa() {
        var retorno = service.findById(empresa.getId());
        assertTrue(retorno.isPresent());
        assertEquals(empresa, retorno.get());
    }

    @Test
    void deveBuscarEmpresas() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        empresa.setEmail("granza@gmail.com");
        service.save(empresa);
        var retorno = service.findById(empresa.getId());
        assertTrue(retorno.isPresent());
        Assertions.assertEquals("granza@gmail.com", retorno.get().getEmail());
    }

    @Test
    void deveConsultarLinhasDaEmpresa() {
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        linhaService.save(linha);
        var linhas = linhaService.linhasDaEmpresa(empresa);
        assertTrue(linhas.contains(linha));
    }

    @Test
    void deveConsultarVeiculosDaEmpresa() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        veiculoService.save(veiculo);
        var veiculos = veiculoService.veiculosDaEmpresa(empresa);
        assertTrue(veiculos.contains(veiculo));
    }
}
