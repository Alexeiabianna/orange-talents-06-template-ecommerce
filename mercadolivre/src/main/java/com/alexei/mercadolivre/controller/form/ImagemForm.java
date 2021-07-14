package com.alexei.mercadolivre.controller.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class ImagemForm {

    @Size(min = 0)
    @NotNull
    private List<MultipartFile> imagens = new ArrayList<>();

    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public Set<String> getLinks() {

        String servidorImagens = "http://servidorimagens.com.br/upload";
        
        return this.imagens.stream().map(imagem -> servidorImagens + imagem.getOriginalFilename())
                .collect(Collectors.toSet());
    }

}
