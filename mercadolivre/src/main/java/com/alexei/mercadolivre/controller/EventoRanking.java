package com.alexei.mercadolivre.controller;

import java.util.Map;

import com.alexei.mercadolivre.models.Compra;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EventoRanking implements EventoCompraConcluida {

    @Override
    public void processa(Compra compra) {
        RestTemplate rTemplate = new RestTemplate();
        Map<String, Object> request = Map.of("id", compra.getId(), "idVendedor", compra.getProduto().getVendedor().getId());
        rTemplate.postForEntity("http://localhost:8080/ranking", request, String.class);        
    }
    
}
