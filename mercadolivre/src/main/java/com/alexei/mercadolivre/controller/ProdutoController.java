package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.ProdutoForm;
import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.repository.CategoriaRepository;
import com.alexei.mercadolivre.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid ProdutoForm form) {
        if (form.isEqualNomeCaracteristica(form.getCaracteristicas())) {
            return ResponseEntity.badRequest().body(new Exception("Não é permitido caracteristicas com nome igual."));
        }
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(form.getIdCategoria());
        Categoria categoria = optionalCategoria.get();
        Produto produto = form.toModel(categoria);
        produtoRepository.save(produto);        
        return ResponseEntity.ok().build();
    }

}
