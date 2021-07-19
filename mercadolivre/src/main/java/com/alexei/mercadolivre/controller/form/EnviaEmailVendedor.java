package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Usuario;

import org.springframework.stereotype.Component;

@Component
public class EnviaEmailVendedor implements EnviaEmail {

    @Override
    public void enviaEmail(String mensagem, Usuario usuario) {
        String email = usuario.getEmail();
        String corpoEmail = mensagem;

        System.out.println("Email enviado para vendedor");
        System.out.println(email + "\nMensagem: \n" + corpoEmail);
    }

}
