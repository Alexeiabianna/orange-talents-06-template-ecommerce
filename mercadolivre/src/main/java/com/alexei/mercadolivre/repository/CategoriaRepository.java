package com.alexei.mercadolivre.repository;

import java.util.Optional;

import com.alexei.mercadolivre.models.Categoria;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    
    Optional<Categoria> findById(Long id);
}
