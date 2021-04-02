package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmpresaServiceTest {

    @Autowired
    private EmpresaService service;

    @Test
    void deveCadastrarEmpresa() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        var rotorno = service.save(empresa);
        assertEquals(empresa, rotorno);
    }

    @Test
    void deveBuscarEmpresa() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(empresa);
        var retorno = service.findById(empresa.getId());
        assertTrue(retorno.isPresent());
        assertEquals(empresa, retorno.get());
    }

    @Test
    void deveBuscarEmpresas() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(empresa);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(empresa);
        empresa.setEmail("granza@gmail.com");
        service.save(empresa);
        var retorno = service.findById(empresa.getId());
        assertTrue(retorno.isPresent());
        Assertions.assertEquals("granza@gmail.com", retorno.get().getEmail());
    }
}
