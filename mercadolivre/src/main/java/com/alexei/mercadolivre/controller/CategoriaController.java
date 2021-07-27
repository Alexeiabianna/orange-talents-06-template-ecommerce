package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.produto.CategoriaForm;
import com.alexei.mercadolivre.models.Categoria;
import com.alexei.mercadolivre.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid CategoriaForm form) {
        Categoria categoria = form.toModel();
        if(form.getIdCategoriaMae() == null){
            categoriaRepository.save(categoria);
            return ResponseEntity.ok().build();
        }
        Optional<Categoria> optionalCategoriaMae = categoriaRepository.findById(form.getIdCategoriaMae());
        if(optionalCategoriaMae.isPresent()){
            Categoria categoriaMae = optionalCategoriaMae.get();
            categoria.setCategoriaMae(categoriaMae);
            categoriaRepository.save(categoria);
    
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
