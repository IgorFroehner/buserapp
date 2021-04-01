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
        var igorLtda = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        var usuarioRetornado = service.save(igorLtda);
        assertEquals(igorLtda, usuarioRetornado);
    }

    @Test
    void deveBuscarEmpresa() {
        var igorLtda = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(igorLtda);
        var cliente = service.findById(igorLtda.getId());
        assertTrue(cliente.isPresent());
        assertEquals(igorLtda, cliente.get());
    }

    @Test
    void deveBuscarEmpresas() {
        var igorLtda = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(igorLtda);
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        var igorLtda = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        service.save(igorLtda);
        igorLtda.setEmail("granza@gmail.com");
        service.save(igorLtda);
        var empresa = service.findById(igorLtda.getId());
        assertTrue(empresa.isPresent());
        Assertions.assertEquals("granza@gmail.com", empresa.get().getEmail());
    }
}
