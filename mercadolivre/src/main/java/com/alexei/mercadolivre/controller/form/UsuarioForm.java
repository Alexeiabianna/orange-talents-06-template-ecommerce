package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Usuario;

public class UsuarioForm {

    private String email;
    private String senha;

    public UsuarioForm() {

    }

    public String getEmail() {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public Usuario toModel() {
        return new Usuario(this.email, this.senha);
    }

}
