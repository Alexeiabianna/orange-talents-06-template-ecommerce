package com.alexei.mercadolivre.controller;

import com.alexei.mercadolivre.controller.form.UsuarioForm;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody UsuarioForm form) {
        Usuario usuario = form.toModel();
        usuarioRepository.save(usuario);
        System.out.println(usuario.getSenha());

        return ResponseEntity.ok().build();
    }
}
