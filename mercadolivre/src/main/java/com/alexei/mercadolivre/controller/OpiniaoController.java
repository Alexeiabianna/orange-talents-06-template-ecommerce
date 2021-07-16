package com.alexei.mercadolivre.controller;

import javax.validation.Valid;

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
    public ResponseEntity<?> cria(@RequestBody @Valid OpiniaoForm form) {
       
        return ResponseEntity.ok().body(form);
    }
    
}
