package com.alexei.mercadolivre.controller.form.produto;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public interface UploaderImagens {
    List<String> envia(List<MultipartFile> list);
}
