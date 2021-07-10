package com.alexei.mercadolivre.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.alexei.mercadolivre.config.validation.UniqueValue;
import com.alexei.mercadolivre.models.Usuario;

import org.hibernate.validator.constraints.Length;

public class UsuarioForm {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Usuario.class, fieldName = "email")
    private String email;

    @NotBlank
    @Length(min = 6)
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
