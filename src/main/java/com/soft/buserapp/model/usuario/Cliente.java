package com.soft.buserapp.model.usuario;

import com.soft.buserapp.model.Usuario;
import javax.persistence.*;

@Entity
public class Cliente extends Usuario {

    @Column
    private String cpf;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String email, String senha, String cpf1) {
        super(id, nome, email, senha);
        this.cpf = cpf1;
    }

}
