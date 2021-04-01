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
    private Integer numeroParadas;

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

}
