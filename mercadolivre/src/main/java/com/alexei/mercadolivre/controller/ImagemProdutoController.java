package com.alexei.mercadolivre.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.produto.GeraLinkImagem;
import com.alexei.mercadolivre.controller.form.produto.ImagemForm;
import com.alexei.mercadolivre.controller.form.produto.UploaderImagens;
import com.alexei.mercadolivre.models.Produto;
import com.alexei.mercadolivre.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imagem")
public class ImagemProdutoController {

    private ProdutoRepository produtoRepository;
    private UploaderImagens uploaderImagens;

    @Autowired
    public ImagemProdutoController(ProdutoRepository produtoRepository, GeraLinkImagem uploaderImagens) {
        this.produtoRepository = produtoRepository;
        this.uploaderImagens = uploaderImagens;
    }

    @PostMapping("/{id}")
    @Transactional
    public ResponseEntity<?> adicionaImagem(@PathVariable Long id, @Valid ImagemForm form) {

        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()) {
            List<String> listaLinks = uploaderImagens.envia(form.getImagens());

            System.out.println(listaLinks);
            
            Produto produto = optionalProduto.get();
            produto.addImagem(listaLinks);

            produtoRepository.save(produto);

            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

}
