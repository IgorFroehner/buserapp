package com.soft.buserapp.service;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.review.Review;
import com.soft.buserapp.model.usuario.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewServiceTest {

    @Autowired private ReviewService service;
    @Autowired private EmpresaService empresaService;
    @Autowired private ClienteService clienteService;

    Empresa empresa = new Empresa("IgorLtda", "igorltda@igor", "12312312312", 123L);
    Cliente cliente = new Cliente("Igor", "igor@igor", "12312312312", 123L);

    private Review review;

    @BeforeEach
    void setUp() {
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

    @Test
    void deveBuscarReviewPorEmpresa() {
        var reviews = service.findByEmpresa(empresa);
        assertFalse(reviews.isEmpty());
        assertTrue(reviews.contains(review));
    }

    @Test
    void deveBuscarReviewPorCliente() {
        var reviews = service.findByCliente(cliente);
        assertFalse(reviews.isEmpty());
        assertTrue(reviews.contains(review));
    }

}