package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.veiculo.Veiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VeiculoServiceTest {

    @Autowired
    private VeiculoService service;

    @Autowired
    private EmpresaService empresaService;

    private final Empresa empresa = new Empresa("EmpresaTeste", "teste@teste.com", "123", 123L);;

    @BeforeEach
    void setUp() {
        empresaService.save(empresa);
    }

    @Test
    void deveCadastrarVeiculo() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        var retorno = service.save(veiculo);
        assertEquals(veiculo, retorno);
    }

    @Test
    void deveBuscarVeiculo() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        service.save(veiculo);
        var retorno = service.findById(veiculo.getId());
        assertTrue(retorno.isPresent());
        assertEquals(veiculo, retorno.get());
    }

    @Test
    void deveBuscarVeiculos() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        service.save(veiculo);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarVeiculos() {
        var veiculo = new Veiculo("Uno", "BAN-1001", 2006, empresa);
        service.save(veiculo);
        veiculo.setAno(2012);
        service.save(veiculo);
        var retorno = service.findById(veiculo.getId());
        assertTrue(retorno.isPresent());
        assertEquals(2012, retorno.get().getAno());
    }
}
