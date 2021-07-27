package com.alexei.mercadolivre.controller;

import javax.validation.Valid;

import com.alexei.mercadolivre.controller.form.compra.NotaFiscalForm;
import com.alexei.mercadolivre.controller.form.compra.RankingForm;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistemas")
public class SistemasExtras {

    @PostMapping("/notas-fiscais")
	public ResponseEntity<?> criaNota(@Valid @RequestBody NotaFiscalForm form) {
		System.out.println("criando nota "+form);
        return ResponseEntity.ok().body(form);
	}

	@PostMapping("/ranking")
	public ResponseEntity<?> ranking(@Valid @RequestBody RankingForm form) {
		System.out.println("criando ranking"+form);
        return ResponseEntity.ok().body(form);
	}
    
}
