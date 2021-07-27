package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.alexei.mercadolivre.config.validation.ErroDeFormularioDto;
import com.alexei.mercadolivre.controller.form.compra.CompraForm;
import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.models.Usuario;
import com.alexei.mercadolivre.repository.CompraRepository;
import com.alexei.mercadolivre.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/compra")
public class CompraController {

    private ProdutoRepository produtoRepository;
    private CompraRepository compraRepository;
    private EnviaEmail enviaEmail;

    @Autowired
    public CompraController(ProdutoRepository produtoRepository, CompraRepository compraRepository, EnviaEmail enviaEmail) {
        this.produtoRepository = produtoRepository;
        this.compraRepository = compraRepository;
        this.enviaEmail = enviaEmail;
    }

    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody @Valid CompraForm form, @AuthenticationPrincipal Usuario user) { 
        
        if(!produtoRepository.existsById(form.getIdProduto())) {
            return ResponseEntity.badRequest().body(new ErroDeFormularioDto("produto", "inexistente"));
        }  

        Optional<Produto> optionalProduto = produtoRepository.findById(form.getIdProduto());     
        Produto produto = optionalProduto.get();
        Compra compra = form.toModel(produto, user);

        if(compra.isValidEstoque(form.getQuantidade())){
            compraRepository.save(compra);
            produto.setQuantidade(compra.getquantidade());
            produtoRepository.save(produto);
            enviaEmail.enviaEmail(produto, user);

            return ResponseEntity.status(HttpStatus.FOUND).header("Redirect", compra.getTipoPagamento().getUrl()).build();
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(new ErroDeFormularioDto("quantidade", "Estoque indisponível"));  

    }
    
    
}
