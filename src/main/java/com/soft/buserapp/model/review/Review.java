package com.soft.buserapp.model.review;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.usuario.Cliente;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer nota;

    @Column
    private String feedback;

    @OneToOne
    private Empresa empresa;

    @OneToOne
    private Cliente cliente;

    public Review(Long id, Integer nota, String feedback, Empresa empresa, Cliente cliente) {
        this.id = id;
        this.nota = nota;
        this.feedback = feedback;
        this.empresa = empresa;
        this.cliente = cliente;
    }

    public Review() {
    }

    public Review(Integer nota, String feedback, Empresa empresa, Cliente cliente) {
        this.nota = nota;
        this.feedback = feedback;
        this.empresa = empresa;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id);
    }

}
