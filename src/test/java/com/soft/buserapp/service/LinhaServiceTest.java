package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.endereco.Endereco;
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
public class LinhaServiceTest {

    @Autowired private LinhaService service;
    @Autowired private EmpresaService empresaService;
    @Autowired private VeiculoService veiculoService;
    @Autowired private EnderecoService enderecoService;

    private Empresa empresa;
    private Linha linha;

    @BeforeEach
    void setUp() {
        empresa = new Empresa("EmpresaTeste", "teste@teste.com", "123", 123L);
        empresaService.save(empresa);
        linha = new Linha("Centro - Udesc", LocalTime.NOON, LocalTime.now(), empresa, new BigDecimal("5.00"));
        service.save(linha);
    }

    @Test
    public void deveSalvarLinha() {
        var retorno = service.save(linha);
        assertEquals(linha, retorno);
    }

    @Test
    void deveRemoverLinha() {
        service.delete(linha);
        assertTrue(service.findById(linha.getId()).isEmpty());
    }

    @Test
    void deveRemoverEnderecosDaLinha() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        enderecoService.save(endereco);
        service.delete(linha);
        assertTrue(enderecoService.enderecosDaLinha(linha).isEmpty());
        var retorno = enderecoService.findById(endereco.getId());
        assertFalse(retorno.isPresent());
    }

    @Test
    void deveNaoRemoverVeiculosDaLinha() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        veiculoService.save(veiculo);
        veiculoService.adicionaVeiculoNaLinha(veiculo, linha);
        service.delete(linha);
        assertTrue(veiculoService.veiculosDaLinha(linha).isEmpty());
        var retorno = veiculoService.findById(veiculo.getId());
        assertTrue(retorno.isPresent());
        assertNull(retorno.get().getLinha());
    }

    @Test
    void deveBuscarLinha() {
        var retorno = service.findById(linha.getId());
        assertTrue(retorno.isPresent());
        assertEquals(linha, retorno.get());
    }

    @Test
    void deveBuscarLinhas() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarLinha() {
        linha.setPreco(BigDecimal.ZERO);
        service.save(linha);
        var retorno = service.findById(linha.getId());
        assertTrue(retorno.isPresent());
        assertEquals(0, BigDecimal.ZERO.compareTo(retorno.get().getPreco()));
    }

    @Test
    void deveConsultarEnderecosDaLinha() {
        var endereco = new Endereco(BigDecimal.ONE, BigDecimal.ONE, "Rua Estudante AAA", 123, linha);
        enderecoService.save(endereco);
        var enderecos = enderecoService.enderecosDaLinha(linha);
        assertTrue(enderecos.contains(endereco));
    }
}
