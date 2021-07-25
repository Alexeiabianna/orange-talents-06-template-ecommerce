package com.alexei.mercadolivre.controller.form;

import java.net.URI;

public interface RedirectGateway {
    URI redireciona(TipoGateway gateway);    
}
