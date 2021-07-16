package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.OpiniaoForm;
import com.alexei.mercadolivre.models.Opiniao;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.OpiniaoRepository;
import com.alexei.mercadolivre.repository.ProdutoRepository;
import com.alexei.mercadolivre.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> cria(@PathVariable Long id, @RequestBody @Valid OpiniaoForm form) {
       Optional<Produto> optionalProduto = produtoRepository.findById(id);
       Optional<Usuario> optionalUsuario = usuarioRepository.findById(form.getIdUsuario());
       if(optionalProduto.isPresent()) {
           Produto produto = optionalProduto.get();
           Usuario usuario = optionalUsuario.get();
           Opiniao opiniao = form.toModel(usuario, produto);
           opiniaoRepository.save(opiniao);

           return ResponseEntity.ok().body(opiniao);
       }

       return ResponseEntity.badRequest().build();
       
    }
    
}
