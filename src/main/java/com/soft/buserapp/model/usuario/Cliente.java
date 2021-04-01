package com.soft.buserapp.model.usuario;

import com.soft.buserapp.model.Usuario;
import javax.persistence.*;

@Entity
public class Cliente extends Usuario {

    @Column
    private String cpf;

    public Cliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, String email, String senha, String cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }

}
