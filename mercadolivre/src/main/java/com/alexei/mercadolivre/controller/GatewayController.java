package com.alexei.mercadolivre.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.compra.PagSeguroForm;
import com.alexei.mercadolivre.controller.form.compra.PaypalForm;
import com.alexei.mercadolivre.controller.form.compra.RespostaGateway;
import com.alexei.mercadolivre.models.Compra;
import com.alexei.mercadolivre.repository.CompraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class GatewayController {

    private CompraRepository compraRepository;
    private EventosCompra eventosCompra;

    @Autowired
    public GatewayController(CompraRepository compraRepository, EventosCompra eventosCompra) {
        this.compraRepository = compraRepository;
        this.eventosCompra = eventosCompra;
    }

    @PostMapping("/pagseguro/{id}")
    @Transactional
    public ResponseEntity<?> pagSeguroPagamento(@PathVariable("id") Long id, @Valid PagSeguroForm form) {
        processaPagamento(id, form);
        return ResponseEntity.ok().body(form);
    }

    @PostMapping("/paypal/{id}")
    @Transactional
    public ResponseEntity<?> paypalPagamento(@PathVariable("id") Long id, @Valid PaypalForm form) {
        processaPagamento(id, form);
        return ResponseEntity.ok().body(form);
    }

    private void processaPagamento(Long id, RespostaGateway respostaGateway) {
        Optional<Compra> optionalCompra = compraRepository.findById(id);
        Compra compra = optionalCompra.get();
        if (!compra.isConcluida()) {
            compra.addTransacao(respostaGateway);
            compraRepository.save(compra);

            eventosCompra.processa(compra);
        }
    }

}
