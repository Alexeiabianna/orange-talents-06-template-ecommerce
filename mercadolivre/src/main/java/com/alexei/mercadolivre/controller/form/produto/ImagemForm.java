package com.alexei.mercadolivre.controller.form.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public void setImagens(Set<MultipartFile> imagens) {
        this.imagens.addAll(imagens);
    }
}
