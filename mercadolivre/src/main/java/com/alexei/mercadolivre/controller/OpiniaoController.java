package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.produto.OpiniaoForm;
import com.alexei.mercadolivre.models.Opiniao;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.OpiniaoRepository;
import com.alexei.mercadolivre.repository.ProdutoRepository;
import com.alexei.mercadolivre.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/opiniao")
public class OpiniaoController {

    private OpiniaoRepository opiniaoRepository;
    private UsuarioRepository usuarioRepository;
    private ProdutoRepository produtoRepository;

    @Autowired
    public OpiniaoController(OpiniaoRepository opiniaoRepository, UsuarioRepository usuarioRepository,
            ProdutoRepository produtoRepository) {
        this.opiniaoRepository = opiniaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.produtoRepository = produtoRepository;
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> cria(@PathVariable Long id, @AuthenticationPrincipal Usuario user,
            @RequestBody @Valid OpiniaoForm form) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(user.getUsername());
        if (optionalProduto.isPresent() && optionalUsuario.isPresent()) {
            Produto produto = optionalProduto.get();
            Usuario usuario = optionalUsuario.get();
            Opiniao opiniao = form.toModel(usuario, produto);
            opiniaoRepository.save(opiniao);

            return ResponseEntity.ok().body(form);
        }

        return ResponseEntity.badRequest().build();

    }

}
