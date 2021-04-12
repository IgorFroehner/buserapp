package com.soft.buserapp.model.endereco;

import com.soft.buserapp.model.linha.Linha;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private BigDecimal latitude;

    @Column
    private BigDecimal longitude;

    @Column
    private String rua;

    @Column
    private Integer numero;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Linha linha;

    public Long getId() {
        return id;
    }

    public Endereco() {
    }

    public Endereco(Long id, BigDecimal latitude, BigDecimal longitude, String rua, Integer numero, Linha linha) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rua = rua;
        this.numero = numero;
        this.linha = linha;
    }

    public Endereco(BigDecimal latitude, BigDecimal longitude, String rua, Integer numero, Linha linha) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.rua = rua;
        this.numero = numero;
        this.linha = linha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Linha getLinha() {
        return linha;
    }

    public void setLinha(Linha linha) {
        this.linha = linha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Endereco)) return false;
        Endereco endereco = (Endereco) o;
        return id.equals(endereco.id);
    }

}
