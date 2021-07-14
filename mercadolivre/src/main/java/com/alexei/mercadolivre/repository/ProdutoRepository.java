package com.alexei.mercadolivre.repository;

import com.alexei.mercadolivre.models.Produto;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    
}
