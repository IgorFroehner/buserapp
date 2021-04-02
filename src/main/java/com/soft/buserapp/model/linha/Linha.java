package com.soft.buserapp.model.linha;

import com.soft.buserapp.model.empresa.Empresa;
import com.soft.buserapp.model.endereco.Endereco;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Linha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column
    private LocalTime horarioInicio;

    @Column
    private LocalTime horarioFim;

    @ManyToOne
    private Empresa empresa;

    @Column
    private BigDecimal preco;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Endereco> enderecosParadas;

    // * enderecosParadas
    // * veiculos

    public Linha() {
    }

    public Linha(String titulo, LocalTime horarioInicio, LocalTime horarioFim, Empresa empresa, BigDecimal preco) {
        this.titulo = titulo;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.empresa = empresa;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Linha)) return false;
        Linha linha = (Linha) o;
        return id.equals(linha.id);
    }

    @Override
    public String toString() {
        return "Linha{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", horarioInicio=" + horarioInicio +
                ", horarioFim=" + horarioFim +
                ", empresa=" + empresa +
                ", preco=" + preco +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
