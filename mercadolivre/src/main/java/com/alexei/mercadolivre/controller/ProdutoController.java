package com.alexei.mercadolivre.controller;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.ImagemForm;
import com.alexei.mercadolivre.controller.form.ProdutoForm;
import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.repository.CategoriaRepository;
import com.alexei.mercadolivre.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Transactional
    public ResponseEntity<?> cadastra(@RequestBody @Valid ProdutoForm form) {
        if (form.isEqualNomeCaracteristica(form.getCaracteristicas())) {
            return ResponseEntity.badRequest().body(new Exception("Campo nome características deve ser único"));
        }
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(form.getIdCategoria());
        Categoria categoria = optionalCategoria.get();
        Produto produto = form.toModel(categoria);
        produtoRepository.save(produto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> adicionaImagem(@PathVariable("id") Long id,  @Valid ImagemForm form) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if(optionalProduto.isPresent()) {
            Set<String> listaLinks = form.getLinks();
            Produto produto = optionalProduto.get();
            produto.vinculaImagens(listaLinks);

            produtoRepository.save(produto);
            
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
