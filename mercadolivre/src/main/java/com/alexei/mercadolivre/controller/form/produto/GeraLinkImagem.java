package com.alexei.mercadolivre.controller.form.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class GeraLinkImagem implements UploaderImagens {

    public List<String> envia(List<MultipartFile> list) {
        return list.stream().map(imagem -> "http://servidorimagens.com.br/upload" + imagem.getOriginalFilename())
                .collect(Collectors.toList());
    }
}
