package com.soft.buserapp.model.usuario;

import com.soft.buserapp.model.Usuario;
import javax.persistence.*;

@Entity
public class Cliente extends Usuario {

    @Column
    private Long cpf;

    public Cliente() {
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Cliente(String nome, String email, String senha, Long cpf) {
        super(nome, email, senha);
        this.cpf = cpf;
    }

}
