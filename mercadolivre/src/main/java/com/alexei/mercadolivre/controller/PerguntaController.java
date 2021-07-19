package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.EnviaEmail;
import com.alexei.mercadolivre.controller.form.PerguntaForm;
import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.PerguntaRepository;
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
@RequestMapping("/pergunta")
public class PerguntaController {

    private PerguntaRepository perguntaRepository;
    private ProdutoRepository produtoRepository;
    private UsuarioRepository usuarioRepository;
    private EnviaEmail enviaEmail;

    @Autowired
    public PerguntaController(PerguntaRepository perguntaRepository, ProdutoRepository produtoRepository,
            UsuarioRepository usuarioRepository, EnviaEmail enviaEmail) {
        this.perguntaRepository = perguntaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.enviaEmail = enviaEmail;
    }

    @PostMapping("{id}")
    public ResponseEntity<?> cria(@PathVariable Long id, @RequestBody @Valid PerguntaForm form,
            @AuthenticationPrincipal Usuario user) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(user.getUsername());
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent() && optionalProduto.isPresent()) {
            Usuario usuario = optionalUsuario.get();
            Produto produto = optionalProduto.get();

            Pergunta pergunta = form.toModel(usuario, produto);
            perguntaRepository.save(pergunta);

            enviaEmail.enviaEmail(form.getMensagem(), usuario);
            
            return ResponseEntity.ok().body(form);
        }

        return ResponseEntity.badRequest().build();

    }

}
