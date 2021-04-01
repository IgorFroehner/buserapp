package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.veiculo.Veiculo;
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

    @Test
    void deveCadastrarVeiculo() {
        var testeEmpresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        empresaService.save(testeEmpresa);

        var uno = new Veiculo("Uno", "BAN-1001", 2006, testeEmpresa);
        var veiculo = service.save(uno);
        assertEquals(uno, veiculo);
    }

    @Test
    void deveBuscarVeiculo() {
        var testeEmpresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        empresaService.save(testeEmpresa);
        var uno = new Veiculo("Uno", "BAN-1001", 2006, testeEmpresa);
        service.save(uno);
        var veiculo = service.findById(uno.getId());
        assertTrue(veiculo.isPresent());
        assertEquals(uno, veiculo.get());
    }

    @Test
    void deveBuscarVeiculos() {
        var testeEmpresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        empresaService.save(testeEmpresa);
        var uno = new Veiculo("Uno", "BAN-1001", 2006, testeEmpresa);
        service.save(uno);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarVeiculos() {
        var testeEmpresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        empresaService.save(testeEmpresa);
        var uno = new Veiculo("Uno", "BAN-1001", 2006, testeEmpresa);
        service.save(uno);
        uno.setAno(2012);
        service.save(uno);
        var veiculo = service.findById(uno.getId());
        assertTrue(veiculo.isPresent());
        assertEquals(2012, veiculo.get().getAno());
    }
}
