package com.alexei.mercadolivre.controller;

import com.alexei.mercadolivre.controller.form.UsuarioForm;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    
    @PostMapping
    public String cadastra(@RequestBody UsuarioForm form) {
        return form.getEmail() + form.getSenha();
    }
}
