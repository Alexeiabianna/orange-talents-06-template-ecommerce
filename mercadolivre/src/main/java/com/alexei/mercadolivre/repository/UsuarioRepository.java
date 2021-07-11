package com.alexei.mercadolivre.repository;

import java.util.Optional;

import com.alexei.mercadolivre.models.Usuario;

import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);
    
}
