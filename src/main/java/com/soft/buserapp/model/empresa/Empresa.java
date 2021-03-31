package com.soft.buserapp.model.empresa;

import com.soft.buserapp.model.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empresa extends Usuario {

    @Column
    private Long cnpj;

}
