package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.endereco.Endereco;
import com.soft.buserapp.model.linha.Linha;
import com.soft.buserapp.model.review.Review;
import com.soft.buserapp.model.usuario.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceTest {

    @Autowired private ReviewService service;
    @Autowired private EmpresaService empresaService;
    @Autowired private ClienteService clienteService;

    private Review review;

    @BeforeEach
    void setUp() {
        var empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
        var cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);
        empresaService.save(empresa);
        clienteService.save(cliente);
        review = new Review(5, "Muito bom", empresa, cliente);
        service.save(review);
    }

    @Test
    void deveCadastrarEndereco() {
        var enderecoRetornado = service.save(review);
        assertEquals(review, enderecoRetornado);
    }

    @Test
    void deveBuscarEndereco() {
        var cliente = service.findById(review.getId());
        assertTrue(cliente.isPresent());
        assertEquals(review, cliente.get());
    }

    @Test
    void deveBuscarEmpresas() {
        assertNotNull(service.findAll());
        assertFalse(service.findAll().isEmpty());
    }

    @Test
    void deveAlterarEmpresa() {
        review.setNota(5);
        service.save(review);
        var empresa = service.findById(review.getId());
        assertTrue(empresa.isPresent());
        assertEquals(5, review.getNota());
    }

}