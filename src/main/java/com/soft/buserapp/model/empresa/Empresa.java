package com.soft.buserapp.model.empresa;

import com.soft.buserapp.model.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empresa extends Usuario {

    @Column
    private Long cnpj;

    public Empresa() {
    }

    public Empresa(String nome, String email, String senha, Long cnpj) {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
