package com.alexei.mercadolivre.controller.form;

import com.alexei.mercadolivre.models.Pergunta;
import com.alexei.mercadolivre.models.Produto;
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

    @Override
    public void enviaEmail(Produto produto, Usuario usuario) {
        String email = usuario.getEmail();
        String titulo = produto.getNome();

        System.out.println("AVISO DE VENDA DE PRODUTO");
        System.out.println("Cliente: " + email);
        System.out.println("Produto: " + titulo);
        System.out.println("Estoque atual: " + produto.getQuantidade() );
        
    }

}
