package com.alexei.mercadolivre.controller;

import com.alexei.mercadolivre.controller.form.OpiniaoForm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opiniao")
public class OpiniaoController {

    @PostMapping
    public ResponseEntity<?> cria(@RequestBody OpiniaoForm form) {
        System.out.println(form.getNota());
        System.out.println(form.getTitulo());
        System.out.println(form.getDescricao());
        System.out.println(form.getIdProduto());
        return ResponseEntity.ok().body(form);
    }
    
}
