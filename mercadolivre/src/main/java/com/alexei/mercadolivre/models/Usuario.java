package com.alexei.mercadolivre.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    

    @Deprecated
    public Usuario() {
    }

    public Usuario(String email, String senhaLimpa) {
        this.email = email;
        this.senha = new BCryptPasswordEncoder().encode(senhaLimpa);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

}
