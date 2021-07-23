package com.alexei.mercadolivre.controller;

import java.util.Optional;

import com.alexei.mercadolivre.controller.dto.DetalhesDto;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalhes")
public class DetalhesProdutoController {

    private ProdutoRepository produtoRepository;

    @Autowired
    public DetalhesProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalha(@PathVariable Long id) {
        
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()) {
            Produto produto = optionalProduto.get();
            return ResponseEntity.ok().body(new DetalhesDto(produto));
        }

        return ResponseEntity.badRequest().build();
    }

}
