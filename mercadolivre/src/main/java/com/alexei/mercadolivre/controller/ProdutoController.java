package com.alexei.mercadolivre.controller;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.ProdutoForm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid ProdutoForm form) {
        System.out.println(form.getNome()+" "+form.getDescricao());
        return ResponseEntity.ok().build();
    }
    
}
