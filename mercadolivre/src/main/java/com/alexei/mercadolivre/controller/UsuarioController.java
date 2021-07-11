package com.alexei.mercadolivre.controller;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.UsuarioForm;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid UsuarioForm form) {
        Usuario usuario = form.toModel();
        usuarioRepository.save(usuario);
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getSenha());
        System.out.println(usuario.getDataCriacao());

        return ResponseEntity.ok().build();
    }
}
