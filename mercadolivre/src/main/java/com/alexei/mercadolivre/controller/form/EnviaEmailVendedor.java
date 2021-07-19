package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Usuario;

import org.springframework.stereotype.Component;

@Component
public class EnviaEmailVendedor implements EnviaEmail {

    @Override
    public void enviaEmail(Pergunta pergunta, Usuario usuario) {
        String email = usuario.getEmail();
        String titulo = pergunta.getTitulo();
        String corpoEmail = pergunta.getMensagem();

        System.out.println("Email enviado para vendedor");
        System.out.println("email cliente: " + pergunta.getUsuario().getEmail());
        System.out.println("titulo: "+ titulo +"\n"+"email vendedor: "+ email +"\n" + "Mensagem: \n" + corpoEmail);
    }

}
