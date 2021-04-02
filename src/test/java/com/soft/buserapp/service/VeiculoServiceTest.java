package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.linha.Linha;
import com.soft.buserapp.model.veiculo.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VeiculoServiceTest {

    @Autowired private VeiculoService service;
    @Autowired private EmpresaService empresaService;
    @Autowired private LinhaService linhaService;

    private Veiculo veiculo;

    @BeforeEach
    void setUp() {
        var empresa = new Empresa("EmpresaTeste", "teste@teste.com", "123", 123L);
        empresaService.save(empresa);
        veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        service.save(veiculo);
    }

    @Test
    void deveCadastrarVeiculo() {
        var retorno = service.save(veiculo);
        assertEquals(veiculo, retorno);
    }

    @Test
    void deveRemoverVeiculo() {
        service.delete(veiculo);
        assertTrue(service.findById(veiculo.getId()).isEmpty());
    }

    @Test
    void deveBuscarVeiculo() {
        var retorno = service.findById(veiculo.getId());
        assertTrue(retorno.isPresent());
        assertEquals(veiculo, retorno.get());
    }

    @Test
    void deveBuscarVeiculos() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarVeiculos() {
        veiculo.setAno(2012);
        service.save(veiculo);
        var retorno = service.findById(veiculo.getId());
        assertTrue(retorno.isPresent());
        assertEquals(2012, retorno.get().getAno());
    }

    @Test
    void deveCadastrarVeiculoNaLinha() {
        var empresa = new Empresa("EmpresaTeste", "teste@teste.com", "123", 123L);
        empresaService.save(empresa);
        var linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        linhaService.save(linha);
        service.adicionaVeiculoNaLinha(veiculo, linha);
        var veiculos = service.veiculosDaLinha(linha);
        assertTrue(veiculos.contains(veiculo));
        assertEquals(linha, veiculo.getLinha());
    }
}
