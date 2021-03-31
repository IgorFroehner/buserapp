package com.soft.buserapp.model.veiculo;

import com.soft.buserapp.model.empresa.Empresa;

import javax.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String modelo;

    @Column
    private Long numeroChassi;

    @ManyToOne
    private Empresa empresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Long getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(Long numeroChassi) {
        this.numeroChassi = numeroChassi;
    }
}

